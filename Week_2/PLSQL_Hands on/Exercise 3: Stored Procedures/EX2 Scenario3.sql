SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id      IN Accounts.AccountID%TYPE,
    p_dest_account_id        IN Accounts.AccountID%TYPE,
    p_transfer_amount        IN NUMBER
)
IS
    v_source_before   NUMBER;
    v_dest_before     NUMBER;
    v_source_after    NUMBER;
    v_dest_after      NUMBER;
BEGIN
    -- Get and lock source account
    SELECT Balance INTO v_source_before
    FROM Accounts
    WHERE AccountID = p_source_account_id
    FOR UPDATE;

    -- Check for sufficient balance
    IF v_source_before < p_transfer_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    -- Get and lock destination account
    SELECT Balance INTO v_dest_before
    FROM Accounts
    WHERE AccountID = p_dest_account_id
    FOR UPDATE;

    -- Perform transfer
    UPDATE Accounts
    SET Balance = Balance - p_transfer_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_source_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_transfer_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_dest_account_id;

    -- Get updated balances
    SELECT Balance INTO v_source_after
    FROM Accounts
    WHERE AccountID = p_source_account_id;

    SELECT Balance INTO v_dest_after
    FROM Accounts
    WHERE AccountID = p_dest_account_id;

    -- Print tabular output
    DBMS_OUTPUT.PUT_LINE('Transfer Amount: Rs. ' || p_transfer_amount);
    DBMS_OUTPUT.PUT_LINE(
        RPAD('Operation', 20) ||
        RPAD('Account ID', 15) ||
        RPAD('Before Balance', 20) ||
        'After Balance'
    );

    DBMS_OUTPUT.PUT_LINE(
        RPAD('-', 20, '-') ||
        RPAD('-', 15, '-') ||
        RPAD('-', 20, '-') ||
        RPAD('-', 20, '-')
    );

    DBMS_OUTPUT.PUT_LINE(
        RPAD('Debited From', 20) ||
        RPAD(p_source_account_id, 15) ||
        RPAD(TO_CHAR(v_source_before, '999999.00'), 20) ||
        TO_CHAR(v_source_after, '999999.00')
    );

    DBMS_OUTPUT.PUT_LINE(
        RPAD('Credited To', 20) ||
        RPAD(p_dest_account_id, 15) ||
        RPAD(TO_CHAR(v_dest_before, '999999.00'), 20) ||
        TO_CHAR(v_dest_after, '999999.00')
    );

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('One or both account IDs do not exist.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error during transfer: ' || SQLERRM);
        ROLLBACK;
END;
/
BEGIN
    TransferFunds(1, 3, 500);
END;
/
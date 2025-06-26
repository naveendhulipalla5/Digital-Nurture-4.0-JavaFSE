CREATE OR REPLACE PROCEDURE process_monthly_interest AS
    -- Cursor for all savings accounts
    CURSOR c_savings_accounts IS
        SELECT a.AccountID, a.CustomerID, c.Name AS CustomerName, 
               a.Balance, a.AccountType, a.LastModified
        FROM Accounts a
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE a.AccountType = 'Savings'
        ORDER BY a.AccountID;
    
    -- Variables for processing
    v_process_date DATE := SYSDATE;
    v_total_accounts NUMBER := 0;
    v_total_interest NUMBER := 0;
    v_new_balance NUMBER;
    v_interest_amount NUMBER;
    
    -- Variables for transaction logging
    v_transaction_id NUMBER;
BEGIN
    -- Display processing header
    DBMS_OUTPUT.PUT_LINE('MONTHLY INTEREST PROCESSING - ' || TO_CHAR(v_process_date, 'DD-MON-YYYY HH24:MI:SS'));
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE('ACCOUNT DETAILS');
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    
    -- Process each savings account
    FOR r_account IN c_savings_accounts LOOP
        -- Calculate new balance and interest
        v_interest_amount := ROUND(r_account.Balance * 0.01, 2);
        v_new_balance := r_account.Balance + v_interest_amount;
        
        -- Update account balance
        UPDATE Accounts 
        SET Balance = v_new_balance,
            LastModified = v_process_date
        WHERE AccountID = r_account.AccountID;
        
        -- Get next transaction ID
        SELECT NVL(MAX(TransactionID), 0) + 1 INTO v_transaction_id FROM Transactions;
        
        -- Record interest transaction
        INSERT INTO Transactions (
            TransactionID, AccountID, TransactionDate, 
            Amount, TransactionType
        ) VALUES (
            v_transaction_id, r_account.AccountID, v_process_date,
            v_interest_amount, 'Interest'
        );
        
        -- Update customer balance if needed (assuming customer balance reflects account balances)
        UPDATE Customers
        SET Balance = Balance + v_interest_amount,
            LastModified = v_process_date
        WHERE CustomerID = r_account.CustomerID;
        
        -- Display account processing details
        DBMS_OUTPUT.PUT_LINE(
            'Account ID: ' || RPAD(r_account.AccountID, 8) ||
            ' | Customer: ' || RPAD(r_account.CustomerName, 20) ||
            ' | Old Balance: ' || TO_CHAR(r_account.Balance, '9,999,999.99') ||
            ' | Interest: ' || TO_CHAR(v_interest_amount, '9,999.99') ||
            ' | New Balance: ' || TO_CHAR(v_new_balance, '9,999,999.99')
        );
        
        -- Update totals
        v_total_accounts := v_total_accounts + 1;
        v_total_interest := v_total_interest + v_interest_amount;
    END LOOP;
    
    -- Commit all changes
    COMMIT;
    
    -- Display summary
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE('PROCESSING SUMMARY');
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE('Total Savings Accounts Processed: ' || v_total_accounts);
    DBMS_OUTPUT.PUT_LINE('Total Interest Applied: ' || TO_CHAR(v_total_interest, '9,999,999.99'));
    DBMS_OUTPUT.PUT_LINE('Processing completed successfully at ' || 
                         TO_CHAR(SYSDATE, 'DD-MON-YYYY HH24:MI:SS'));
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
        DBMS_OUTPUT.PUT_LINE('Processing failed - all changes rolled back');
END process_monthly_interest;
/
SET SERVEROUTPUT ON SIZE 1000000;
EXEC process_monthly_interest;
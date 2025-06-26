DECLARE
    CURSOR cur_senior_customers IS
        SELECT CustomerID, TRUNC(MONTHS_BETWEEN(SYSDATE, DOB)/12) AS Age
        FROM Customers;

    v_customer_id Loans.CustomerID%TYPE;
    v_age NUMBER;
BEGIN
    FOR rec IN cur_senior_customers LOOP
        v_customer_id := rec.CustomerID;
        v_age := rec.Age;

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = v_customer_id;

            DBMS_OUTPUT.PUT_LINE('Applied 1% interest discount for CustomerID: ' || v_customer_id || ' (Age: ' || v_age || ')');
        END IF;
    END LOOP;
END;
/
SELECT c.CustomerID, l.LoanID, c.Name, TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS Age, l.InterestRate
FROM Customers c
JOIN Loans l ON c.CustomerID = l.CustomerID
WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) > 60;
DECLARE
  CURSOR c_due_loans IS
    SELECT l.LoanID, l.CustomerID, c.Name, l.LoanAmount, l.InterestRate, l.EndDate,
           TRUNC(l.EndDate - SYSDATE) AS Days_Remaining
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30  -- More precise than <=
    ORDER BY l.EndDate;
    
  v_reminder_count NUMBER := 0;

BEGIN
  DBMS_OUTPUT.PUT_LINE('LOAN DUE REMINDERS (NEXT 30 DAYS)');
  DBMS_OUTPUT.PUT_LINE('====================================');
  DBMS_OUTPUT.PUT_LINE('As of: ' || TO_CHAR(SYSDATE, 'DD-Mon-YYYY HH24:MI'));
  DBMS_OUTPUT.PUT_LINE('------------------------------------');

  FOR loan_rec IN c_due_loans LOOP
    v_reminder_count := v_reminder_count + 1;
    
    DBMS_OUTPUT.PUT_LINE('REMINDER #' || v_reminder_count || ':');
    DBMS_OUTPUT.PUT_LINE('  Customer: ' || loan_rec.Name || ' (ID: ' || loan_rec.CustomerID || ')');
    DBMS_OUTPUT.PUT_LINE('  Loan ID: ' || loan_rec.LoanID);
    DBMS_OUTPUT.PUT_LINE('  Amount: $' || loan_rec.LoanAmount);
    DBMS_OUTPUT.PUT_LINE('  Interest Rate: ' || loan_rec.InterestRate || '%');
    DBMS_OUTPUT.PUT_LINE('  Due Date: ' || TO_CHAR(loan_rec.EndDate, 'DD-Mon-YYYY'));
    DBMS_OUTPUT.PUT_LINE('  Days Remaining: ' || loan_rec.Days_Remaining);
    DBMS_OUTPUT.PUT_LINE('------------------------------------');
  END LOOP;
  
  DBMS_OUTPUT.PUT_LINE('TOTAL REMINDERS GENERATED: ' || v_reminder_count);
  DBMS_OUTPUT.PUT_LINE('====================================');

EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
    DBMS_OUTPUT.PUT_LINE('Failed to generate loan reminders');
END;
/
SELECT l.LoanID, c.Name, l.LoanAmount, l.EndDate, 
       TRUNC(l.EndDate - SYSDATE) AS Days_Remaining
FROM Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
ORDER BY l.EndDate;
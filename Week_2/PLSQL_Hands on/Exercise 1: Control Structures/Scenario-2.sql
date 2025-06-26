SELECT c.CustomerID, c.Name, TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS Age, l.LoanID, l.InterestRate
FROM Customers c
JOIN Loans l ON c.CustomerID = l.CustomerID
WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) > 60;
BEGIN
  DBMS_OUTPUT.PUT_LINE('Updating VIP status...');
  
  UPDATE Customers
  SET IsVIP = 'T',
      LastModified = SYSDATE
  WHERE Balance > 10000;
  
  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' customers promoted to VIP');
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    ROLLBACK;
END;
/
SELECT CustomerID, Name, Balance, IsVIP, LastModified
FROM Customers
ORDER BY CustomerID;
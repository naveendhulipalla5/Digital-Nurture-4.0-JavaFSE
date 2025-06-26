SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department     IN Employees.Department%TYPE,
    p_bonus_percent  IN NUMBER
)
IS
    CURSOR emp_cursor IS
        SELECT EmployeeID, Name, Position, Department, Salary
        FROM Employees
        WHERE Department = p_department
        FOR UPDATE;

    v_bonus_salary   NUMBER;
BEGIN
    -- Header row
    DBMS_OUTPUT.PUT_LINE(
        RPAD('Employee ID', 15) ||
        RPAD('Name', 20) ||
        RPAD('Position', 20) ||
        RPAD('Department', 15) ||
        RPAD('Normal Salary', 18) ||
        'Bonus Salary'
    );

    -- Divider
    DBMS_OUTPUT.PUT_LINE(
        RPAD('-', 15, '-') ||
        RPAD('-', 20, '-') ||
        RPAD('-', 20, '-') ||
        RPAD('-', 15, '-') ||
        RPAD('-', 18, '-') ||
        RPAD('-', 15, '-')
    );

    FOR emp_rec IN emp_cursor LOOP
        -- Calculate bonus salary
        v_bonus_salary := emp_rec.Salary + (emp_rec.Salary * p_bonus_percent / 100);

        -- Update employee salary
        UPDATE Employees
        SET Salary = v_bonus_salary
        WHERE EmployeeID = emp_rec.EmployeeID;

        -- Output in aligned tabular format
        DBMS_OUTPUT.PUT_LINE(
            RPAD(emp_rec.EmployeeID, 15) ||
            RPAD(emp_rec.Name, 20) ||
            RPAD(emp_rec.Position, 20) ||
            RPAD(emp_rec.Department, 15) ||
            RPAD(TO_CHAR(emp_rec.Salary, '999999.00'), 18) ||
            TO_CHAR(v_bonus_salary, '999999.00')
        );
    END LOOP;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error while updating bonuses: ' || SQLERRM);
        ROLLBACK;
END;
/
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
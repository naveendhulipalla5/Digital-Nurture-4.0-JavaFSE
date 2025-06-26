package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
	private Calculator calculator;

    // Setup (runs before each test)
    @Before
    public void setUp() {
        calculator = new Calculator();  // Arrange
        System.out.println("Calculator initialized");
    }

    // Teardown (runs after each test)
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Calculator cleaned up");
    }

    @Test
    public void testAdd() {
        // Act
        int result = calculator.add(2, 3);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(4, 3);
        assertEquals(12, result);
    }

    @Test
    public void testDivide() {
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0);  // Should throw exception
    }
}

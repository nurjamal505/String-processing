import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {

    StringProcessor processor = new StringProcessor(); // Create an instance of StringProcessor

    @Test
    public void testIsStrongPassword() {
        // Test cases for the isStrongPassword method
        System.out.println("Testing isStrongPassword:");

        assertTrue(processor.isStrongPassword("Sigma1234#"), "Expected strong password"); // Test a strong password
        assertFalse(processor.isStrongPassword("sigma1234"), "Expected weak password without uppercase or special symbol"); // Test a weak password
        assertFalse(processor.isStrongPassword("SIGMA!@#"), "Expected weak password without lowercase and digit"); // Test a weak password
        assertFalse(processor.isStrongPassword("12345678#"), "Expected weak password without uppercase or lowercase"); // Test a weak password
        assertFalse(processor.isStrongPassword(""), "Expected weak password: empty string"); // Test an empty password
    }

    @Test
    public void testCalculateDigits() {
        // Test cases for the calculateDigits method
        System.out.println("Testing calculateDigits:");

        assertEquals(3, processor.calculateDigits("Hello123!"), "Expected 3 digits found"); // Three digits
        assertEquals(0, processor.calculateDigits("Hello World!"), "Expected 0 digits found"); // No digits
        assertEquals(0, processor.calculateDigits(""), "Expected 0 digits in empty string"); // Empty string
        assertEquals(2, processor.calculateDigits("12 34"), "Expected 2 digits found"); // Two digits
        assertEquals(4, processor.calculateDigits("1a2b3c4d"), "Expected 4 digits found"); // Four digits
    }

    @Test
    public void testCalculateWords() {
        // Test cases for the calculateWords method
        System.out.println("Testing calculateWords:");

        assertEquals(3, processor.calculateWords("Hello World! Test."), "Expected 3 words found"); // Three words
        assertEquals(0, processor.calculateWords("   "), "Expected 0 words in empty string"); // No words
        assertEquals(1, processor.calculateWords("SingleWord"), "Expected 1 word found"); // One word
        assertEquals(5, processor.calculateWords("   This is a test.   "), "Expected 5 words found with spaces"); // Five words
        assertEquals(4, processor.calculateWords("Word1 Word2 Word3 Word4"), "Expected 4 words found"); // Four words
    }

    @Test
    public void testAdd() {
        // Test cases for the add method
        System.out.println("Testing add method:");

        assertEquals(5, processor.add(2, 3), "Expected 2 + 3 to equal 5"); // Add
        assertEquals(0, processor.add(0, 0), "Expected 0 + 0 to equal 0"); // Add zeros
        assertEquals(10, processor.add(7, 3), "Expected 7 + 3 to equal 10"); // Add positive numbers
        assertEquals(-5, processor.add(-2, -3), "Expected -2 + -3 to equal -5"); // Add negative numbers
        assertEquals(1, processor.add(4, -3), "Expected 4 + -3 to equal 1"); // Add positive and negative
    }

    @Test
    public void testSubtract() {
        // Test cases for the subtract method
        System.out.println("Testing subtract method:");

        assertEquals(-1, processor.subtract(2, 3), "Expected 2 - 3 to equal -1"); // Subtract
        assertEquals(0, processor.subtract(0, 0), "Expected 0 - 0 to equal 0"); // Subtract zeros
        assertEquals(4, processor.subtract(7, 3), "Expected 7 - 3 to equal 4"); // Subtract positive numbers
        assertEquals(1, processor.subtract(-2, -3), "Expected -2 - -3 to equal 1"); // Subtract negatives
        assertEquals(7, processor.subtract(4, -3), "Expected 4 - -3 to equal 7"); // Subtract positive and negative
    }

    @Test
    public void testMultiply() {
        // Test cases for the multiply method
        System.out.println("Testing multiply method:");

        assertEquals(6, processor.multiply(2, 3), "Expected 2 * 3 to equal 6"); // Multiply
        assertEquals(0, processor.multiply(0, 5), "Expected 0 * 5 to equal 0"); // Multiply by zero
        assertEquals(21, processor.multiply(7, 3), "Expected 7 * 3 to equal 21"); // Multiply positive numbers
        assertEquals(6, processor.multiply(-2, -3), "Expected -2 * -3 to equal 6"); // Multiply negatives
        assertEquals(-12, processor.multiply(-4, 3), "Expected -4 * 3 to equal -12"); // Multiply positive and negative
    }

    @Test
    public void testDivide() {
        // Test cases for the divide method
        System.out.println("Testing divide method:");

        assertEquals(2, processor.divide(6, 3), "Expected 6 / 3 to equal 2"); // Divide
        assertThrows(IllegalArgumentException.class, () -> processor.divide(5, 0), "Expected exception for division by zero"); // Division by zero
        assertEquals(3, processor.divide(9, 3), "Expected 9 / 3 to equal 3"); // Divide positive numbers
        assertEquals(1.5, processor.divide(3, 2), "Expected 3 / 2 to equal 1.5"); // Divide with decimal
        assertEquals(-2, processor.divide(-6, 3), "Expected -6 / 3 to equal -2"); // Divide negative and positive
    }
}

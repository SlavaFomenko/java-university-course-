import org.junit.*;
import org.junit.rules.*;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

public class OperationTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private static String testName;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Before all tests");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("After all tests");
    }

    @Before
    public void setUp() {
        testName = "Test Started";
        System.out.println("Before each test");
    }

    @After
    public void tearDown() {
        System.out.println("After each test");
    }

    @Test
    public void testAddition() {
        assertEquals(6, Operation.addition(1, 2, 3));
        assertEquals(0, Operation.addition());
        assertEquals(-6, Operation.addition(-1, -2, -3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(0, Operation.subtraction(1, 1));
        assertEquals(3, Operation.subtraction(5, 2));
        assertEquals(-1, Operation.subtraction(2, 3, 4));
        assertEquals(10, Operation.subtraction(20));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        Operation.division(10, 0);
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, Operation.multiplication(1, 2, 3));
        assertEquals(0, Operation.multiplication(0, 2, 3));
        assertEquals(1, Operation.multiplication(1));
        assertEquals(-6, Operation.multiplication(-1, 2, 3));
    }

    @Test
    public void testAverage() {
        assertEquals(3.0, Operation.average(1, 2, 3, 4, 5), 0.001);
        assertEquals(0.0, Operation.average(), 0.001);
        assertEquals(-2.0, Operation.average(-1, -2, -3), 0.001);
    }

    @Test
    public void testMaximum() {
        assertEquals(5, Operation.maximum(1, 2, 3, 4, 5));
        assertEquals(-1, Operation.maximum(-1, -2, -3, -4, -5));
        assertEquals(0, Operation.maximum(0));
    }

    @Test
    public void testMinimum() {
        assertEquals(1, Operation.minimum(1, 2, 3, 4, 5));
        assertEquals(-5, Operation.minimum(-1, -2, -3, -4, -5));
        assertEquals(0, Operation.minimum(0));
    }

    @Test
    @Ignore("Test ignored for now")
    public void testIgnored() {
        fail("This test should be ignored");
    }

    @Test(timeout = 1000)
    public void testTimeout() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNameRule() {
        System.out.println("Test name is: " + testName);
        assertNotNull(testName);
    }

    @Test
    @Category(SlowTests.class)
    public void slowTest() {
        System.out.println("This is a slow test");
    }

    public interface SlowTests {}
}

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Mock
    private MathService mathService;

    @InjectMocks
    private Calculator calculator;

    @Captor
    private ArgumentCaptor<Integer> argumentCaptor;

    @Before
    public void setUp() {
        // Налаштування перед кожним тестом
    }

    @Test
    public void testAdd() {
        int result = calculator.add(1, 2);
        assertEquals(3, result);
        verify(mathService, never()).multiply(anyInt(), anyInt());
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
        verify(mathService, never()).multiply(anyInt(), anyInt());
    }

    @Test
    public void testMultiply() {
        // Налаштуємо mock для множення
        when(mathService.multiply(2, 3)).thenReturn(6);

        int result = calculator.multiply(2, 3);
        assertEquals(6, result);

        // Перевірка, чи викликано multiply із аргументами (2, 3)
        verify(mathService).multiply(2, 3);
    }

    @Test
    public void testDivide() {
        int result = calculator.divide(6, 2);
        assertEquals(3, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(6, 0);
    }

    @Test
    public void testMultiplyWithThrowing() {
        // Налаштуємо mock для множення, щоб він кидав виключення
        when(mathService.multiply(2, 3)).thenThrow(new RuntimeException("Math error"));

        try {
            calculator.multiply(2, 3);
            fail("Exception should have been thrown");
        } catch (RuntimeException e) {
            assertEquals("Math error", e.getMessage());
        }

        // Перевірка виклику
        verify(mathService).multiply(2, 3);
    }

    @Test
    public void testCaptor() {
        calculator.add(5, 3);
        verify(mathService, times(0)).multiply(argumentCaptor.capture(), argumentCaptor.capture());

        // Тут можна перевірити захоплені аргументи
        assertEquals(5, (int) argumentCaptor.getAllValues().get(0));
        assertEquals(3, (int) argumentCaptor.getAllValues().get(1));
    }

    @Test
    public void testMockitoBehavior() {
        // Налаштуємо mock так, щоб multiply повертало 10
        when(mathService.multiply(2, 5)).thenReturn(10);

        int result = calculator.multiply(2, 5);
        assertEquals(10, result);

        // Перевірка, що метод multiply викликано рівно 1 раз
        verify(mathService, times(1)).multiply(2, 5);
    }

    @Test
    public void testMultipleVerifications() {
        // Викликаємо кілька методів
        calculator.add(1, 1);
        calculator.subtract(10, 3);
        calculator.multiply(3, 3);

        // Перевіряємо кількість викликів методів
        verify(mathService, never()).divide(anyInt(), anyInt());
        verify(mathService, times(1)).multiply(3, 3);
    }
}

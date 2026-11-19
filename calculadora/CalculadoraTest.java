package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    // Helper para invocar métodos privados mantendo a assinatura original do enunciado
    private int invocarMetodoPrivado(String nomeMetodo, int a, int b) throws Throwable {
        Method metodo = Calculadora.class.getDeclaredMethod(nomeMetodo, int.class, int.class);
        metodo.setAccessible(true);
        try {
            return (int) metodo.invoke(calculadora, a, b);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    @Test
    void deveAdicionarDoisNumerosInteiros() throws Throwable {
        assertEquals(8, invocarMetodoPrivado("adicionar", 5, 3));
        assertEquals(-2, invocarMetodoPrivado("adicionar", 5, -7));
        assertEquals(0, invocarMetodoPrivado("adicionar", 0, 0));
    }

    @Test
    void deveSubtrairDoisNumerosInteiros() throws Throwable {
        assertEquals(2, invocarMetodoPrivado("subtrair", 5, 3));
        assertEquals(12, invocarMetodoPrivado("subtrair", 5, -7));
        assertEquals(-5, invocarMetodoPrivado("subtrair", 0, 5));
    }

    @Test
    void deveMultiplicarDoisNumerosInteiros() throws Throwable {
        assertEquals(15, invocarMetodoPrivado("multiplicar", 5, 3));
        assertEquals(-15, invocarMetodoPrivado("multiplicar", 5, -3));
        assertEquals(0, invocarMetodoPrivado("multiplicar", 10, 0));
    }

    @Test
    void deveDividirDoisNumerosInteiros() throws Throwable {
        assertEquals(5, invocarMetodoPrivado("dividir", 10, 2));
        assertEquals(3, invocarMetodoPrivado("dividir", 10, 3)); // Divisão inteira
        assertEquals(-4, invocarMetodoPrivado("dividir", -12, 3));
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> invocarMetodoPrivado("dividir", 10, 0)
        );
        assertTrue(exception.getMessage().contains("/ by zero"));
    }
}
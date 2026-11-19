import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    void deveRetornarCasosBaseZeroEUm() {
        assertEquals(0, fibonacci.calcularRecursivo(0));
        assertEquals(1, fibonacci.calcularRecursivo(1));
    }

    @Test
    void deveCalcularFibonacciDeCincoCorretamente() {
        // Conforme a árvore de recursão para fib(5): 0, 1, 1, 2, 3, 5 -> fib(5) = 5
        assertEquals(5, fibonacci.calcularRecursivo(5));
        assertEquals(8, fibonacci.calcularRecursivo(6));
    }

    @Test
    void deveLancarExcecaoParaNumeroNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> fibonacci.calcularRecursivo(-1)
        );
    }
}
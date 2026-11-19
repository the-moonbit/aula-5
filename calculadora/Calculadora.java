package calculadora;
/**
 * classe pra realizar operações aritméticas básicas
 * com números inteiros.
 */
public class Calculadora {

    /**
     * soma dois inteiros.
     *
     * @param a primeiro operando inteiro
     * @param b segundo operando inteiro
     * @return o resultado da adição {@code a + b}
     */
    private int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * subtrai o segundo número inteiro do primeiro.
     *
     * @param a minuendo inteiro
     * @param b subtraendo inteiro
     * @return o resultado da subtração {@code a - b}
     */
    private int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * multiplica dois números inteiros.
     *
     * @param a primeiro fator inteiro
     * @param b segundo fator inteiro
     * @return o resultado da multiplicação {@code a * b}
     */
    private int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * divide o primeiro número inteiro pelo segundo (divisão inteira).
     *
     * @param a dividendo inteiro
     * @param b divisor inteiro (não deve ser zero)
     * @return o quociente inteiro da divisão {@code a / b}
     * @throws ArithmeticException se {@code b} for igual a zero
     */
    private int dividir(int a, int b) {
        return a / b;
    }
}
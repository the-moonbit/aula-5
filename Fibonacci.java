public class Fibonacci {

    public int calcularRecursivo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O índice n não pode ser negativo.");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return calcularRecursivo(n - 1) + calcularRecursivo(n - 2);
    }
}
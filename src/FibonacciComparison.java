import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class FibonacciComparison {

    // Algoritma Fibonacci dengan Memoisasi
    public static Map<Integer, Long> memo = new HashMap<>();

    public static long fibonacciMemoization(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            long fib = fibonacciMemoization(n - 1) + fibonacciMemoization(n - 2);
            memo.put(n, fib);
            return fib;
        }
    }

    // Algoritma Fibonacci Iteratif
    public static long fibonacciIterative(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long a = 0;
        long b = 1;
        long fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nilai n : ");
        int n = scanner.nextInt();

        System.out.println("n = " + n);

        // Mengukur waktu eksekusi algoritma Fibonacci dengan Memoisasi
        long startTimeMemoization = System.nanoTime();
        long resultMemoization = fibonacciMemoization(n);
        long endTimeMemoization = System.nanoTime();
        long elapsedTimeMemoization = endTimeMemoization - startTimeMemoization;

        // Mengukur waktu eksekusi algoritma Fibonacci Iteratif
        long startTimeIterative = System.nanoTime();
        long resultIterative = fibonacciIterative(n);
        long endTimeIterative = System.nanoTime();
        long elapsedTimeIterative = endTimeIterative - startTimeIterative;

        System.out.println("Hasil Fibonacci dengan Memoisasi: " + resultMemoization);
        System.out.println("Waktu Eksekusi dengan Memoisasi: " + (elapsedTimeMemoization / 1e6) + " ms");
        System.out.println("Hasil Fibonacci Iteratif: " + resultIterative);
        System.out.println("Waktu Eksekusi Iteratif: " + (elapsedTimeIterative / 1e6) + " ms");

        scanner.close();
    }
}

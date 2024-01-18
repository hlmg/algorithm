package baekjoon.x0b;

import java.util.Scanner;

public class P1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(recursive(a, b, c));
    }

    public static long recursive(int a, int b, int c) {
        if (b == 0) {
            return 1;
        }

        long x = recursive(a, b / 2, c);
        if (b % 2 == 1) {
            return (x * x % c) * a % c;
        } else {
            return x * x % c;
        }
    }
}

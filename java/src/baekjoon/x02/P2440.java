package baekjoon.x02;

import java.util.Scanner;

public class P2440 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("*".repeat(n - i));
        }
    }
}

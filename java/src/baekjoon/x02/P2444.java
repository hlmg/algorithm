package baekjoon.x02;

import java.util.Scanner;

public class P2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j >= n - 1 - i) {
                    row.append("*");
                } else {
                    row.append(" ");
                }
            }

            for (int j = 0; j < n; j++) {
                if (j < i) {
                    row.append("*");
                }
            }
            System.out.println(row);
        }

        for (int i = 1; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    row.append("*");
                } else {
                    row.append(" ");
                }
            }

            for (int j = 0; j < n; j++) {
                if (j < n - 1 - i) {
                    row.append("*");
                }
            }
            System.out.println(row);
        }
    }
}

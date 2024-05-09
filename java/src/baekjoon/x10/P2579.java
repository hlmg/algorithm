package baekjoon.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[300 + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = Integer.parseInt(br.readLine());
        }
        int[][] d = new int[2][300 + 1];
        d[0][1] = p[1];
        d[1][1] = p[1];
        for (int i = 2; i <= n; i++) {
            d[0][i] = d[1][i - 1] + p[i];
            d[1][i] = Math.max(d[0][i - 2], d[1][i - 2]) + p[i];
        }
        System.out.print(Math.max(d[0][n], d[1][n]));
    }
}

package baekjoon.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[][] d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            d[i][0] = 1;
            d[i][i] = 1;
            for (int j = 1; j < i; j++) {
                d[i][j] = (d[i-1][j-1] + d[i-1][j]) % 10007;
            }
        }
        System.out.println(d[n][k]);
    }
}

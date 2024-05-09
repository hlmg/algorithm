package baekjoon.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] s = new int[n+1][3];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            s[i+1][0] = Integer.parseInt(input[0]);
            s[i+1][1] = Integer.parseInt(input[1]);
            s[i+1][2] = Integer.parseInt(input[2]);
        }
        int[][] d = new int[1001][3];
        d[1][0] = s[1][0];
        d[1][1] = s[1][1];
        d[1][2] = s[1][2];
        if (n <= 1) {
            System.out.print(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));
            return;
        }
        for (int i = 2; i <= n; i++) {
             d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + s[i][0];
             d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + s[i][1];
             d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + s[i][2];
        }
        System.out.print(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));
    }
}

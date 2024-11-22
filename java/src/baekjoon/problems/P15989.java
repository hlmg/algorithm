package baekjoon.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15989 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] d = new int[n + 3][4];
            d[1][1] = 1;
            d[2][1] = 1;
            d[2][2] = 1;
            d[3][1] = 1;
            d[3][2] = 1;
            d[3][3] = 1;

            for (int j = 4; j <= n; j++) {
                d[j][1] = d[j - 1][1];
                d[j][2] = d[j - 2][1] + d[j - 2][2];
                d[j][3] = d[j - 3][1] + d[j - 3][2] + d[j - 3][3];
            }

            System.out.println(d[n][1] + d[n][2] + d[n][3]);
        }

    }
}

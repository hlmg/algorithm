package baekjoon.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P23971 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);
        int m = Integer.parseInt(input[3]);

        int row = n + 1;
        int a = h / row;
        if (h % row > 0) {
            a++;
        }

        int col = m + 1;
        int b = w / col;
        if (w % col > 0) {
            b++;
        }

        System.out.print(a * b);
    }
}

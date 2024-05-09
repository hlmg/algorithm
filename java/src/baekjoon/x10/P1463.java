package baekjoon.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] count = new int[Math.max(3, x) + 1];
        count[1] = 0;
        for (int i = 2; i <= x; i++) {
            count[i] = count[i - 1] + 1;
            if (i % 3 == 0) {
                count[i] = Math.min(count[i / 3] + 1, count[i]);
            }
            if (i % 2 == 0) {
                count[i] = Math.min(count[i / 2] + 1, count[i]);
            }
        }
        System.out.print(count[x]);
    }
}

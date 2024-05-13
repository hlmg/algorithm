package baekjoon.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}

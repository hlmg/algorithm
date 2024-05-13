package baekjoon.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                sb.append(i).append("\n");
            }
        }
        if (n != 1) {
            sb.append(n);
        }
        System.out.print(sb);
    }
}

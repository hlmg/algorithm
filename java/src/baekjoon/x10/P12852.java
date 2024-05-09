package baekjoon.x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[1000001];
        int[] route = new int[1000001];

        for (int i = 2; i <= n; i++) {
            int pre = i - 1;
            d[i] = d[i - 1] + 1;
            if (i % 3 == 0) {
                if (d[i / 3] + 1 < d[i]) {
                    d[i] = d[i / 3] + 1;
                    pre = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (d[i / 2] + 1 < d[i]) {
                    d[i] = d[i / 2] + 1;
                    pre = i / 2;
                }
            }
            route[i] = pre;
        }
        System.out.println(d[n]);
        StringBuilder sb = new StringBuilder();
        int pre = n;
        while (pre != 0) {
            sb.append(pre).append(" ");
            pre = route[pre];
        }
        System.out.print(sb);
    }
}

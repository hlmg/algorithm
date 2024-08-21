package baekjoon.x1c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14938 {
    public static void main(String[] args) {
        final int INF = 15 * 100;
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int[][] d = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i], INF);
        }
        int[] item = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            item[i] = sc.nextInt();
        }
        for (int i = 0; i < r; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            if (w < d[u][v]) {
                d[u][v] = w;
                d[v][u] = w;
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        d[i][j] = 0;
                        continue;
                    }
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int itemCount = 0;
            for (int j = 1; j <= n; j++) {
                if (d[i][j] <= m) {
                    itemCount += item[j];
                }
            }
            answer = Math.max(answer, itemCount);
        }
        System.out.print(answer);
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new IllegalArgumentException();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

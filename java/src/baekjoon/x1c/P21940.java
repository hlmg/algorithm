package baekjoon.x1c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P21940 {
    public static void main(String[] args) {
        final int INF = 1000 * 200;
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] d = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            if (w < d[u][v]) {
                d[u][v] = w;
            }
        }
        int k = sc.nextInt();
        int[] cities = new int[k];
        for (int i = 0; i < k; i++) {
            cities[i] = sc.nextInt();
        }
        for (int u = 1; u <= n; u++) {
            for (int i = 1; i <= n; i++ ){
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        d[i][j] = 0;
                        continue;
                    }
                    if (d[i][u] + d[u][j] < d[i][j]) {
                        d[i][j] = d[i][u] + d[u][j];
                    }
                }
            }
        }
        int min = INF;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int dist = 0;
            for (int city : cities) {
                if (d[i][city] == INF || d[city][i] == INF) {
                    dist = INF;
                    break;
                }
                dist = Math.max(dist, d[i][city] + d[city][i]);
            }
            if (dist < min) {
                min = dist;
                sb = new StringBuilder();
                sb.append(i).append(" ");
            } else if(dist == min) {
                sb.append(i).append(" ");
            }
        }
        System.out.print(sb);
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

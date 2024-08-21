package baekjoon.x1c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P11780 {
    public static void main(String[] args) {
        final int INF = 100_000 * 100;
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] d = new int[n + 1][n + 1];
        int[][] adj = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            d[u][v] = Math.min(d[u][v], sc.nextInt());
            adj[u][v] = v;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        d[i][j] = 0;
                        continue;
                    }
                    int w = d[i][k] + d[k][j];
                    if (w < d[i][j]) {
                        d[i][j] = w;
                        adj[i][j] = adj[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(d[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (adj[i][j] == 0) {
                    sb.append(0).append("\n");
                    continue;
                }
                int from = i;
                List<Integer> route = new ArrayList<>();
                route.add(from);
                while (true) {
                    route.add(adj[from][j]);
                    if (adj[from][j] == j) {
                        break;
                    }
                    from = adj[from][j];
                }
                sb.append(route.size()).append(" ");
                for (int x : route) {
                    sb.append(x).append(" ");
                }
                sb.append("\n");
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

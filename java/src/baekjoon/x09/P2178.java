package baekjoon.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    private final static int[] dy = {1, -1, 0, 0};
    private final static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = sc.next().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(0);
        que.offer(0);
        que.offer(1);
        while (!que.isEmpty()) {
            Integer y = que.poll();
            Integer x = que.poll();
            Integer d = que.poll();
            if (y == n - 1 && x == m - 1) {
                System.out.println(d);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (map[ny][nx] == 0) {
                    continue;
                }
                que.offer(ny);
                que.offer(nx);
                que.offer(d + 1);
                map[ny][nx] = 0;
            }
        }
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

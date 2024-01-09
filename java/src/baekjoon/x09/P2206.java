package baekjoon.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
    public static void main(String[] args) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][][] dist = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(0);
        que.offer(0);
        que.offer(0);
        // dist[y][x][k:부순 횟수]
        dist[0][0][0] = 1;
        while (!que.isEmpty()) {
            Integer y = que.poll();
            Integer x = que.poll();
            Integer k = que.poll();
            if (y == n - 1 && x == m - 1) {
                System.out.println(dist[y][x][k]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                if (map[ny][nx] == '0' && dist[ny][nx][k] == 0) {
                    dist[ny][nx][k] = dist[y][x][k] + 1;
                    que.offer(ny);
                    que.offer(nx);
                    que.offer(k);
                }

                if (map[ny][nx] == '1' && dist[ny][nx][1] == 0 && k == 0) {
                    dist[ny][nx][1] = dist[y][x][0] + 1;
                    que.offer(ny);
                    que.offer(nx);
                    que.offer(1);
                }
            }
        }
        System.out.println(-1);
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

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

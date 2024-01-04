package baekjoon.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int[] dz = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dx = {0, 0, 0, 0, 1, -1};

        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][][] map = new int[h][n][m];
        int[][][] distance = new int[h][n][m];

        int remain = 0;
        Queue<Tomato> que = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int type = sc.nextInt();
                    map[i][j][k] = type;
                    if (type == 1) {
                        que.offer(new Tomato(i, j, k));
                        distance[i][j][k] = 0;
                        continue;
                    }
                    if (type == 0) {
                        remain++;
                    }
                    distance[i][j][k] = -1;
                }
            }
        }

        int day = 0;
        while (!que.isEmpty()) {
            Tomato t = que.poll();
            int z = t.z;
            int y = t.y;
            int x = t.x;
            int d = distance[z][y][x];
            day = Math.max(day, d);
            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (nz < 0 || ny < 0 || nx < 0 || nz >= h || ny >= n || nx >= m) {
                    continue;
                }
                if (map[nz][ny][nx] != 0 || distance[nz][ny][nx] != -1) {
                    continue;
                }
                distance[nz][ny][nx] = d + 1;
                remain--;
                que.offer(new Tomato(nz, ny, nx));
            }
        }
        if (remain > 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(day);
    }

    private static class Tomato {
        int z;
        int y;
        int x;

        public Tomato(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
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

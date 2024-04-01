package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14503 {
    static int n, m;
    static int r, c;
    static int d;
    static int[][] map;
    // 북, 동, 남, 서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        while(true) {
            // 0: dirty, 1: wall, 2: clean
            if (map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }

            if (hasDirty(r, c)) {
                while (true) {
                    if (--d == -1) {
                        d = 3;
                    }
                    int ny = r + dy[d];
                    int nx = c + dx[d];
                    if (map[ny][nx] == 0) {
                        r = ny;
                        c = nx;
                        break;
                    }
                }
            } else {
                int nd = (d + 2) % 4;
                r += dy[nd];
                c += dx[nd];
                if (map[r][c] == 1) {
                    break;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean hasDirty(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int ny = r + dy[i];
            int nx = c + dx[i];
            if (map[ny][nx] == 0) {
                return true;
            }
        }
        return false;
    }

    private static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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

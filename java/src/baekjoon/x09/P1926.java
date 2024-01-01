package baekjoon.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1926 {
    private final static int[] dy = {1, -1, 0, 0};
    private final static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int regionCount = 0;
        int largestRegionSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    regionCount++;
                    int size = dfs(i, j, map);
                    largestRegionSize = Math.max(size, largestRegionSize);
                }
            }
        }
        System.out.println(regionCount);
        System.out.println(largestRegionSize);
    }

    private static int dfs(int y, int x, int[][] map) {
        if (map[y][x] == 0) {
            return 0;
        }
        int size = 1;
        map[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) {
                continue;
            }
            size += dfs(ny, nx, map);
        }
        return size;
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

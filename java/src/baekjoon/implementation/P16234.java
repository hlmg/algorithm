package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16234 {
    static int n, l, r;
    static int[][] map;
    static int[][] visited;
    static int size;
    static int union;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void input() {
        FastScanner sc = new FastScanner();
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

    public static void solve() {
        int answer = -1;
        boolean isContinue = true;
        while (isContinue) {
            visited = new int[n][n];
            union = 1;
            isContinue = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    size = 0;
                    if (visited[i][j] == 0) {
                        size = map[i][j];
                        visited[i][j] = union;
                        int count = dfs(i, j);
                        if (count > 1) {
                            setAvg(union, size, count);
                            isContinue = true;
                        }
                        union++;
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }

    public static int dfs(int y, int x) {
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] != 0) {
                continue;
            }
            int m = Math.abs(map[ny][nx] - map[y][x]);
            if (l <= m && m <= r) {
                visited[ny][nx] = union;
                count += dfs(ny, nx);
                size += map[ny][nx];
            }
        }
        return count;
    }

    private static void setAvg(int union, int size, int count) {
        int avg = size / count;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == union) {
                    map[i][j] = avg;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new IllegalArgumentException();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

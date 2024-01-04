package baekjoon.x09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10026 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[] dy = {0, 0, 1, -1};
    private static final int[] dx = {1, -1, 0, 0};
    private static int n;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        solve();
        bw.close();
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            System.arraycopy(row, 0, map[i], 0, row.length);
        }
    }

    private static void solve() throws IOException {
        int count = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        bw.write(count + " ");
    }

    private static void dfs(int y, int x) {
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;
        int color = map[y][x];
        if (color == 'R' || color == 'G') {
            map[y][x] = 'O';
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]) {
                continue;
            }

            if (color != map[ny][nx]) {
                continue;
            }

            dfs(ny, nx);
        }
    }
}

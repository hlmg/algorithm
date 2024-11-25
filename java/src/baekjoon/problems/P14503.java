package baekjoon.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int n, m, answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);

        System.out.print(answer);
    }

    private static void dfs(int r, int c, int d) {
        if (map[r][c] == 0 && !visited[r][c]) {
            visited[r][c] = true;
            answer++;
        }

        boolean dirty = false;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (map[nr][nc] == 0 && !visited[nr][nc]) {
                dirty = true;
                break;
            }
        }

        if (dirty) {
            int i = (d + 3) % 4;
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (map[nr][nc] == 0 && !visited[nr][nc]) {
                dfs(nr, nc, i);
            } else {
                dfs(r, c, i);
            }
        } else {
            int i = (d + 2) % 4;
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (map[nr][nc] == 1) {
                return;
            }
            dfs(nr, nc, d);
        }
    }
}

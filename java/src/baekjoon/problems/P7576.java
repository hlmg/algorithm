package baekjoon.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    static final int[] dy = {0, 0, 1, -1};
    static final int[] dx = {1, -1, 0, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] map;
    static int maxDay;

    public static void main(String[] args) throws Exception {
        m = nextInt();
        n = nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int input = nextInt();
                map[i][j] = input;
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(maxDay);
    }

    private static void bfs() {
        Queue<Tomato> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    que.offer(new Tomato(i, j, 0));
                }
            }
        }

        while (!que.isEmpty()) {
            Tomato cur = que.poll();
            maxDay = Math.max(maxDay, cur.day);
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (map[ny][nx] != 0) {
                    continue;
                }
                map[ny][nx] = 1;
                que.offer(new Tomato(ny, nx, cur.day + 1));
            }
        }
    }

    static int nextInt() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Integer.parseInt(st.nextToken());
    }

    static class Tomato {
        int y;
        int x;
        int day;

        public Tomato(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}

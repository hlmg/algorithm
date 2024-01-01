package baekjoon.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179 {
    private static final int[] dy = {0, 0, 1, -1};
    private static final int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int r = sc.nextInt();
        int c = sc.nextInt();

        Character[][] map = new Character[r][c];
        int[][] distance = new int[r][c];

        Pair jihoon = null;
        Queue<Pair> que = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            char[] input = sc.next().toCharArray();
            for (int j = 0; j < c; j++) {
                char character = input[j];
                if (character == 'J') {
                    jihoon = new Pair(i, j);
                } else if (character == 'F') {
                    que.offer(new Pair(i, j));
                }
                map[i][j] = character;
            }
        }

        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int y = pair.y;
            int x = pair.x;
            int nd = distance[y][x] + 1;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }
                if (map[ny][nx] == '#' || map[ny][nx] == 'F' || distance[ny][nx] != 0) {
                    continue;
                }
                que.offer(new Pair(ny, nx));
                distance[ny][nx] = nd;
            }
        }

        que.offer(jihoon);
        int[][] distance_jihoon = new int[r][c];
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int y = pair.y;
            int x = pair.x;
            int nd = distance_jihoon[y][x] + 1;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    System.out.println(nd);
                    return;
                }
                if (map[ny][nx] != '.' || distance_jihoon[ny][nx] != 0
                        || (distance[ny][nx] != 0 && distance[ny][nx] <= nd)) {
                    continue;
                }
                que.offer(new Pair(ny, nx));
                distance_jihoon[ny][nx] = nd;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
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

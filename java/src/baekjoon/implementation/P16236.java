package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16236 {
    static int[][] map;
    static int n;
    static int time;
    static Shark shark;
    static int[][] bfsMap;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int input = sc.nextInt();
                if (input == 9) {
                    shark = new Shark(i, j);
                    continue;
                }
                map[i][j] = input;
            }
        }

        while (true) {
            int minDist = bfs();
            if (minDist == Integer.MAX_VALUE) {
                break;
            }
            eat(minDist);
        }

        System.out.println(time);
    }

    private static void eat(int minDist) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && map[i][j] < shark.size && bfsMap[i][j] == minDist) {
                    shark.eat(i, j);
                    time += minDist;
                    map[i][j] = 0;
                    return;
                }
            }
        }
    }

    private static int bfs() {
        bfsMap = new int[n][n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(shark.y);
        queue.offer(shark.x);
        queue.offer(0);
        int minDist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Integer y = queue.poll();
            Integer x = queue.poll();
            Integer d = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if (map[ny][nx] > shark.size || bfsMap[ny][nx] != 0) {
                    continue;
                }

                if (d + 1 > minDist) {
                    continue;
                }

                if (map[ny][nx] != 0 && map[ny][nx] < shark.size) {
                    minDist = d + 1;
                }

                queue.offer(ny);
                queue.offer(nx);
                queue.offer(d + 1);
                bfsMap[ny][nx] = d + 1;
            }

        }
        return minDist;
    }

    private static class Shark {
        int y;
        int x;
        int size = 2;
        int exp = 0;

        public Shark(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void eat(int y, int x) {
            exp++;
            if (exp == size) {
                size++;
                exp = 0;
            }
            this.y = y;
            this.x = x;
        }
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

package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P15686 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static List<Pair> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static final int[] dy = {0, 0, -1, 1};
    static final int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int input = sc.nextInt();
                if (input == 2) {
                    chickens.add(new Pair(i, j));
                }
                map[i][j] = input;
            }
        }
        rec(new ArrayList<>(), chickens.size());
        System.out.println(answer);
    }

    private static void rec(List<Pair> list, int j) {
        if (list.size() == m) {
            answer = Math.min(answer, getDistance(list));
            return;
        }
        for (int i = 0; i < j; i++) {
            list.add(chickens.get(i));
            rec(list, i);
            list.remove(list.size() - 1);
        }
    }

    private static int getDistance(List<Pair> list) {
        visited = new boolean[n][n];
        Queue<Pair> que = new ArrayDeque<>(list);
        int distance = 0;
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = pair.y + dy[i];
                int nx = pair.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                visited[ny][nx] = true;
                if (map[ny][nx] == 1) {
                    distance += pair.distance + 1;
                }
                que.offer(new Pair(ny, nx, pair.distance + 1));
            }
        }
        return distance;
    }

    private static class Pair {
        int y;
        int x;
        int distance;

        public Pair(int y, int x) {
            this(y, x, 0);
        }

        public Pair(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
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

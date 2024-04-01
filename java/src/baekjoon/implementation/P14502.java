package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14502 {
    static int n, m;
    static int[][] map;
    static List<Pair> viruses = new ArrayList<>();
    static boolean[][] visited;
    static final int[] dy = {0, 0, 1, -1};
    static final int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        List<Pair> blanks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int input = sc.nextInt();
                if (input == 0) {
                    blanks.add(new Pair(i, j));
                } else if (input == 2) {
                    viruses.add(new Pair(i, j));
                }
                map[i][j] = input;
            }
        }

        int answer = 0;
        for (int i = 0; i < blanks.size(); i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    map[blanks.get(i).y][blanks.get(i).x] = 1;
                    map[blanks.get(j).y][blanks.get(j).x] = 1;
                    map[blanks.get(k).y][blanks.get(k).x] = 1;
                    answer = Math.max(answer, spread());
                    map[blanks.get(i).y][blanks.get(i).x] = 0;
                    map[blanks.get(j).y][blanks.get(j).x] = 0;
                    map[blanks.get(k).y][blanks.get(k).x] = 0;
                }
            }
        }
        System.out.println(answer);
    }

    private static int spread() {
        visited = new boolean[n][m];
        for (Pair virus : viruses) {
            visited[virus.y][virus.x] = true;
            dfs(virus.y, virus.x);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j] == 0 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if (map[ny][nx] != 0 || visited[ny][nx]) {
                continue;
            }
            visited[ny][nx] = true;
            dfs(ny, nx);
        }
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

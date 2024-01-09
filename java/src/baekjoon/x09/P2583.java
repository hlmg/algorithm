package baekjoon.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P2583 {
    private static final int[] dy = {0, 0, -1, 1};
    private static final int[] dx = {-1, 1, 0, 0};
    private static int m, n;
    private static int[][] map;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();

        map = new int[m][n];
        while (k-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = -1;
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != -1) {
                    answer.add(dfs(i, j));
                    count++;
                }
            }
        }
        System.out.println(count);

        Collections.sort(answer);
        for (Integer num : answer) {
            System.out.print(num + " ");
        }
    }

    private static int dfs(int y, int x) {
        if (y < 0 || x < 0 || y >= m || x >= n || map[y][x] == -1) {
            return 0;
        }

        map[y][x] = -1;

        int count = 1;
        for (int i = 0; i < 4; i++) {
            count += dfs(y + dy[i], x + dx[i]);
        }
        return count;
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

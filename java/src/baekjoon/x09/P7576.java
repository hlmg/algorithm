package baekjoon.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    private static final int[] dy = {0, 0, 1, -1};
    private static final int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] map = new int[n][m];

        int unripeTomatoes = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int input = sc.nextInt();
                if (input == 0) {
                    unripeTomatoes++;
                }
                map[i][j] = input;
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    que.offer(i);
                    que.offer(j);
                    que.offer(0);
                    map[i][j] = -1;
                }
            }
        }

        int answer = 0;
        while (!que.isEmpty()) {
            Integer y = que.poll();
            Integer x = que.poll();
            Integer d = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nd = d + 1;
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (map[ny][nx] != 0) {
                    continue;
                }
                que.offer(ny);
                que.offer(nx);
                que.offer(nd);
                answer = nd;
                map[ny][nx] = -1;
                unripeTomatoes--;
            }
        }

        if (unripeTomatoes > 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
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

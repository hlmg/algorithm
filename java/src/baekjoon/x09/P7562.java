package baekjoon.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    private static final FastScanner sc = new FastScanner();
    private static final int[] dy = {-2, -1, 1, 2,2, 1, -1, -2};
    private static final int[] dx = {1, 2, 2, 1,-1, -2, -2, -1};
    private static int l;
    private static int[][] map;
    private static int startY, startX;
    private static int targetY, targetX;

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            init();
            solve();
        }
    }

    private static void init() {
        l = sc.nextInt();
        map = new int[l][l];
        for (int i = 0; i < l; i++) {
            Arrays.fill(map[i], -1);
        }
        startY = sc.nextInt();
        startX = sc.nextInt();
        targetY = sc.nextInt();
        targetX = sc.nextInt();
    }

    private static void solve() {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(startY);
        que.offer(startX);
        map[startY][startX] = 0;
        while (!que.isEmpty()) {
            Integer y = que.poll();
            Integer x = que.poll();
            if (y == targetY && x == targetX) {
                break;
            }
            for (int i = 0; i < dy.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= l || nx >= l || map[ny][nx] != -1) {
                    continue;
                }
                que.offer(ny);
                que.offer(nx);
                map[ny][nx] = map[y][x] + 1;
            }
        }
        System.out.println(map[targetY][targetX]);
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

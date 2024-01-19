package baekjoon.x0b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1780 {
    public static int[] answer = new int[3];
    public static int[][] map;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        rec(0, 0, n);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static void rec(int y, int x, int len) {
        int num = map[y][x];

        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (map[i][j] != num) {
                    len = len / 3;
                    int y2 = y + len;
                    int y3 = y + (2 * len);
                    int x2 = x + len;
                    int x3 = x + (2 * len);
                    rec(y, x, len);
                    rec(y, x2, len);
                    rec(y, x3, len);
                    rec(y2, x, len);
                    rec(y2, x2, len);
                    rec(y2, x3, len);
                    rec(y3, x, len);
                    rec(y3, x2, len);
                    rec(y3, x3, len);
                    return;
                }
            }
        }
        answer[num + 1]++;
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

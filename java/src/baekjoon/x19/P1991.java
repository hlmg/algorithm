package baekjoon.x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1991 {
    static int[] lc;
    static int[] rc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        lc = new int[n];
        rc = new int[n];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            char c = row.charAt(0);
            char l = row.charAt(2);
            char r = row.charAt(4);
            if (l != '.') {
                lc[c - 'A'] = l - 'A';
            }
            if (r != '.') {
                rc[c - 'A'] = r - 'A';
            }
        }
        StringBuilder sb = new StringBuilder();
        pre(0, sb);
        sb.append("\n");
        in(0, sb);
        sb.append("\n");
        post(0, sb);
        System.out.print(sb);
    }

    private static void pre(int current, StringBuilder sb) {
        sb.append((char) (current + 'A'));
        if (lc[current] != 0) {
            pre(lc[current], sb);
        }
        if (rc[current] != 0) {
            pre(rc[current], sb);
        }
    }

    private static void in(int current, StringBuilder sb) {
        if (lc[current] != 0) {
            in(lc[current], sb);
        }
        sb.append((char) (current + 'A'));
        if (rc[current] != 0) {
            in(rc[current], sb);
        }
    }

    private static void post(int current, StringBuilder sb) {
        if (lc[current] != 0) {
            post(lc[current], sb);
        }
        if (rc[current] != 0) {
            post(rc[current], sb);
        }
        sb.append((char) (current + 'A'));
    }
}

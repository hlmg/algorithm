package baekjoon.x0f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7795 {
    static FastScanner sc = new FastScanner();
    static int n, m;
    static int[] a;
    static int[] b;

    private static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];
        b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
    }

    private static void solve() {
        Arrays.sort(a);
        Arrays.sort(b);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] > b[j]) {
                    answer++;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solve();
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

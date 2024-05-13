package baekjoon.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6064 {
    static FastScanner sc = new FastScanner();

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int last = lcm(n, m);

        for (int day = x; day <= last; day += n) {
            if ((day - y) % m == 0){
                System.out.println(day);
                return;
            }
        }
        System.out.println(-1);
    }

    private static int lcm(int n, int m) {
        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        return n / gcd(n, m) * m;
    }

    private static int gcd(int n, int m) {
        if (n == 0) {
            return m;
        }
        return gcd(m % n, n);
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

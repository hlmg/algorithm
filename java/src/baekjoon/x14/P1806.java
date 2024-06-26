package baekjoon.x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int r = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        for (int l = 0; l < n; l++) {
            while (r < n && sum < s) {
                sum += arr[r];
                r++;
            }
            if (sum >= s) {
                length = Math.min(length, r - l);
            }
            sum -= arr[l];
        }
        if (length == Integer.MAX_VALUE) {
            System.out.print(0);
        } else {
            System.out.print(length);
        }
    }

    private static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new IllegalArgumentException();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

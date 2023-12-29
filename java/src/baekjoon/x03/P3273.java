package baekjoon.x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3273 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] nums = new int[n];
        boolean[] has = new boolean[1_000_000];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums[i] = num;
            has[num] = true;
        }
        int x = sc.nextInt();

        int answer = 0;
        for (int a : nums) {
            int b = x - a;
            if (b < 0 || b >= 1_000_000 || a == b) {
                continue;
            }
            if (has[b]) {
                has[b] = false;
                has[a] = false;
                answer++;
            }
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

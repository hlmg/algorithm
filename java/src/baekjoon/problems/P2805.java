package baekjoon.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = nextInt();
        }
        int l = 0;
        int r = 2_000_000_000;
        int answer = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            long sum = getSum(mid, trees);
            if (sum >= m) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static long getSum(int h, int[] trees) {
        long sum = 0;
        for (int tree : trees) {
            if (tree >= h) {
                sum += tree - h;
            }
        }
        return sum;
    }

    static int nextInt() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Integer.parseInt(st.nextToken());
    }
}

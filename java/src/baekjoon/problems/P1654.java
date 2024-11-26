package baekjoon.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int k = nextInt();
        int n = nextInt();
        int[] arr = new int[k];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int input = nextInt();
            arr[i] = input;
            maxLength = Math.max(maxLength, input);
        }
        long l = 1;
        long r = maxLength;
        long answer = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            long count = getCount(mid, arr);
            if (count >= n) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static long getCount(long mid, int[] arr) {
        long count = 0;
        for (int n : arr) {
            count += n / mid;
        }
        return count;
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

package baekjoon.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int c = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        Arrays.sort(arr);

        int left = 1;
        int right = 1_000_000_000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = getCount(mid, arr);
            if (count >= c) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static int getCount(int distance, int[] arr) {
        int count = 1;
        int position = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - position >= distance) {
                position = arr[i];
                count++;
            }
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

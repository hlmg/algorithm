package baekjoon.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10816 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            sb.append(findUpperBound(arr, num) - findLowerBound(arr, num)).append(" ");
        }
        System.out.print(sb);
    }

    private static int findUpperBound(int[] arr, int num) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private static int findLowerBound(int[] arr, int num) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
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

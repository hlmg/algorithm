package baekjoon.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18870 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums[i] = num;
            arr[i] = num;
        }
        Arrays.sort(arr);
        int[] distinctArray = new int[n];
        int pre = -1;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (pre != arr[i]) {
                distinctArray[j] = arr[i];
                pre = arr[i];
                j++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(search(distinctArray, num, j)).append(" ");
        }
        System.out.print(sb);
    }

    private static int search(int[] arr, int num, int len) {
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] < num) {
                l = mid + 1;
            } else if (arr[mid] > num) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        throw new IllegalArgumentException();
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

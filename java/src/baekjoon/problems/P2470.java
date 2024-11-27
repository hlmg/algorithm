package baekjoon.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 1;
        int[] answer = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];
            int abs = Math.abs(sum);
            if (abs < min) {
                min = abs;
                answer[0] = arr[left];
                answer[1] = arr[right];
            }
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break;
            }
        }
        System.out.printf("%d %d", answer[0], answer[1]);
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

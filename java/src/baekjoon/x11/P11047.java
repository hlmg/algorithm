package baekjoon.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k / arr[i] > 0) {
                answer += k / arr[i];
                k = k % arr[i];
            }
            if (k == 0) {
                break;
            }
        }
        System.out.println(answer);
    }
}

package baekjoon.x0e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수의 범위가 10_000_000 이하면 Counting sort
public class P15688 {
    static int[] freq = new int[2_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            freq[Integer.parseInt(br.readLine()) + 1_000_000]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                sb.append(i - 1_000_000).append("\n");
                freq[i]--;
            }
        }
        System.out.print(sb);
    }
}

package baekjoon.x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class P13975 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() throws IOException {
        Queue<Long> pq = new PriorityQueue<>();
        int k = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        for (String num : nums) {
            pq.offer(Long.parseLong(num));
        }
        long answer = 0;
        while(k-- > 1) {
            long sum = pq.poll() + pq.poll();
            answer += sum;
            pq.offer(sum);
        }
        System.out.println(answer);
    }
}

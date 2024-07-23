package baekjoon.x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class P2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split(" ");
            for (String num : nums) {
                pq.offer(Integer.parseInt(num));
            }
        }
        for (int i = 0; i < n - 1; i++) {
            pq.poll();
        }
        System.out.print(pq.poll());
    }
}

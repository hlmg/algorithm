package baekjoon.x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            pq.offer(x);
        }
        int answer = 0;
        while(pq.size() >= 2) {
            int sum = pq.poll() + pq.poll();
            answer += sum;
            pq.offer(sum);
        }
        System.out.print(answer);
    }
}

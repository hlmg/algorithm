package baekjoon.x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> pq2 = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            Integer y = pq1.peek();
            if (y == null || x <= y) {
                pq1.offer(x);
            } else {
                pq2.offer(x);
            }
            if (pq1.size() < pq2.size()) {
                pq1.offer(pq2.poll());
            } else if (pq1.size() > pq2.size() + 1) {
                pq2.offer(pq1.poll());
            }
            sb.append(pq1.peek()).append("\n");
        }
        System.out.print(sb);
    }
}

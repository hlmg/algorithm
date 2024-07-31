package baekjoon.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] adj = new boolean[n + 1][n + 1];
        while (true) {
            String[] row = br.readLine().split(" ");
            int u = Integer.parseInt(row[0]);
            int v = Integer.parseInt(row[1]);
            if (u == -1) {
                break;
            }
            adj[u][v] = true;
            adj[v][u] = true;
        }

        int score = Integer.MAX_VALUE;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int maxDepth = 0;
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> que = new ArrayDeque<>();
            visited[i] = true;
            que.offer(i);
            que.offer(maxDepth);
            while (!que.isEmpty()) {
                Integer u = que.poll();
                Integer depth = que.poll();
                maxDepth = Math.max(maxDepth, depth);
                for (int v = 1; v <= n; v++) {
                    if (!adj[u][v] || visited[v]) {
                        continue;
                    }
                    visited[v] = true;
                    que.offer(v);
                    que.offer(depth + 1);
                }
            }
            if (maxDepth > score) {
                continue;
            }
            if (maxDepth < score) {
                score = maxDepth;
                count = 0;
                sb = new StringBuilder();
            }
            count++;
            sb.append(i).append(" ");
        }
        System.out.printf("%d %d%n", score, count);
        System.out.print(sb);
    }
}

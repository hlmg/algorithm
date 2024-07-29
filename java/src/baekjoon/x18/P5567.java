package baekjoon.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[][] adj = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            adj[a][b] = true;
            adj[b][a] = true;
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(1);
        que.offer(0);
        visited[1] = true;
        int answer = 0;
        while (!que.isEmpty()) {
            Integer a = que.poll();
            Integer depth = que.poll();
            if (depth >= 2) {
                continue;
            }
            for (int b = 1; b < adj[a].length; b++) {
                if (!adj[a][b] || visited[b]) {
                    continue;
                }
                que.offer(b);
                que.offer(depth + 1);
                visited[b] = true;
                answer++;
            }
        }
        System.out.print(answer);
    }
}

package baekjoon.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        boolean[][] map = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            map[u][v] = true;
            map[v][u] = true;
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i, map, visited);
                answer++;
            }
        }
        System.out.print(answer);
    }

    private static void bfs(int u, boolean[][] map, boolean[] visited) {
        Queue<Integer> que = new ArrayDeque<>();
        visited[u] = true;
        que.offer(u);
        while (!que.isEmpty()) {
            u = que.poll();
            for (int v = 1; v < map[u].length; v++) {
                if (!map[u][v] || visited[v]) {
                    continue;
                }
                visited[v] = true;
                que.offer(v);
            }
        }
    }
}

package baekjoon.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmv = br.readLine().split(" ");
        int n = Integer.parseInt(nmv[0]);
        int m = Integer.parseInt(nmv[1]);
        int v = Integer.parseInt(nmv[2]);
        boolean[][] map = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            map[a][b] = true;
            map[b][a] = true;
        }
        StringBuilder sb = new StringBuilder();
        dfs(v, map, new boolean[n + 1], sb);
        sb.append("\n");
        bfs(v, map, new boolean[n + 1], sb);
        System.out.print(sb);
    }

    private static void dfs(int u, boolean[][] map, boolean[] visited, StringBuilder sb) {
        visited[u] = true;
        sb.append(u).append(" ");
        for (int v = 1; v < map[u].length; v++) {
            if (!map[u][v] || visited[v]) {
                continue;
            }
            dfs(v, map, visited, sb);
        }
    }

    private static void bfs(int u, boolean[][] map, boolean[] visited, StringBuilder sb) {
        Queue<Integer> que = new ArrayDeque<>();
        sb.append(u).append(" ");
        visited[u] = true;
        que.offer(u);
        while (!que.isEmpty()) {
            u = que.poll();
            for (int v = 1; v < map[u].length; v++) {
                if (!map[u][v] || visited[v]) {
                    continue;
                }
                sb.append(v).append(" ");
                visited[v] = true;
                que.offer(v);
            }
        }
    }
}

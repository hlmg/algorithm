package baekjoon.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] adj = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(row[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(dfs(i, j, adj, new boolean[n])).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int dfs(int current, int target, int[][] adj, boolean[] visited) {
        for (int next = 0; next < adj.length; next++) {
            if (adj[current][next] == 0 || visited[next]) {
                continue;
            }
            if (next == target) {
                return 1;
            }
            visited[next] = true;
            if (dfs(next, target, adj, visited) == 1) {
                return 1;
            }
        }
        return 0;
    }
}

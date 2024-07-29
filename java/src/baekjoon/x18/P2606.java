package baekjoon.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2606 {
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
        System.out.print(dfs(1, adj, visited) - 1);
    }

    private static int dfs(int a, boolean[][] adj, boolean[] visited) {
        int answer = 1;
        visited[a] = true;
        for (int b = 1; b < adj[a].length; b++) {
            if (!adj[a][b] || visited[b]) {
                continue;
            }
            answer += dfs(b, adj, visited);
        }
        return answer;
    }
}

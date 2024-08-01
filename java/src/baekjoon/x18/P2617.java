package baekjoon.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] adj1 = new int[n + 1][n + 1];
        int[][] adj2 = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            adj1[a][b] = 1;
            adj2[b][a] = 1;
        }

        int answer = 0;
        int mid = (n + 1) / 2;
        for (int i = 1; i <= n; i++) {
            int c1 = dfs(i, adj1, new boolean[n + 1]);
            int c2 = dfs(i, adj2, new boolean[n + 1]);
            if (c1 > mid || c2 > mid) {
                answer++;
            }
        }
        System.out.print(answer);
    }

    private static int dfs(int i, int[][] adj, boolean[] visited) {
        int count = 1;
        if (visited[i]) {
            return 0;
        }
        visited[i] = true;
        for (int j = 1; j < adj[i].length; j++) {
            if (visited[j] || adj[i][j] == 0) {
                continue;
            }
            count += dfs(j, adj, visited);
        }
        return count;
    }
}

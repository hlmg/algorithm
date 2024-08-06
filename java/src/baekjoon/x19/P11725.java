package baekjoon.x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] row = br.readLine().split(" ");
            int u = Integer.parseInt(row[0]);
            int v = Integer.parseInt(row[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] p = new int[n + 1];
        dfs(1, adj, p);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(p[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int current, List<List<Integer>> adj, int[] p) {
        for (int next : adj.get(current)) {
            if (p[current] == next) {
                continue;
            }
            p[next] = current;
            dfs(next, adj, p);
        }
    }
}

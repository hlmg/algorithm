package baekjoon.x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P4803 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] p;
    static boolean[] visited;
    static int n;
    static int m;
    static int loop;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws IOException {
        while (input()) {
            loop++;
            solve();
        }
    }

    private static boolean input() throws IOException {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        if (n == 0 && m == 0) {
            return false;
        }
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] row = br.readLine().split(" ");
            int u = Integer.parseInt(row[0]);
            int v = Integer.parseInt(row[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        p = new int[n + 1];
        visited = new boolean[n + 1];
        return true;
    }

    private static void solve() {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    count++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
            }
        }
        if (count > 1) {
            System.out.printf("Case %d: A forest of %d trees.%n", loop, count);
        } else if (count == 1) {
            System.out.printf("Case %d: There is one tree.%n", loop);
        } else {
            System.out.printf("Case %d: No trees.%n", loop);
        }
    }

    private static boolean dfs(int u) {
        if (visited[u]) {
            return false;
        }
        visited[u] = true;
        boolean hasTree = true;
        for (int v : adj.get(u)) {
            if (p[u] == v) {
                continue;
            }
            p[v] = u;
            hasTree = dfs(v) && hasTree;
        }
        return hasTree;
    }
}

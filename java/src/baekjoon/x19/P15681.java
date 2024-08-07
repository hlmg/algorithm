package baekjoon.x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P15681 {
    static int[] nodeCount;
    static List<List<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nrq = br.readLine().split(" ");
        int n = Integer.parseInt(nrq[0]);
        int r = Integer.parseInt(nrq[1]);
        int q = Integer.parseInt(nrq[2]);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        nodeCount = new int[n + 1];
        dfs(r, -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(nodeCount[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb);
    }

    private static int dfs(int u, int p) {
        int count = 1;
        for (int v : adj.get(u)) {
            if (v == p) {
                continue;
            }
            count += dfs(v, u);
        }
        nodeCount[u] = count;
        return count;
    }
}

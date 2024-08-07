package baekjoon.x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1240 {
    static List<List<Node>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            int w = Integer.parseInt(uvw[2]);
            adj.get(u).add(new Node(v, w));
            adj.get(v).add(new Node(u, w));
        }
        for (int i = 0; i < m; i++) {
            String[] ft = br.readLine().split(" ");
            int from = Integer.parseInt(ft[0]);
            int target = Integer.parseInt(ft[1]);
            dfs(from, target, -1, 0);
        }
    }

    private static void dfs(int from, int target, int p, int distance) {
        if (from == target) {
            System.out.println(distance);
        }
        for (Node n : adj.get(from)) {
            if (n.to == p) {
                continue;
            }
            dfs(n.to, target, from, distance + n.weight);
        }
    }

    private static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}

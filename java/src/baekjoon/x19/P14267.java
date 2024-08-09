package baekjoon.x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class P14267 {
    static int[] scores;
    static List<List<Integer>> adj;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int root = 0;
        adj = new ArrayList<>();
        String[] p = br.readLine().split(" ");
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = i + 1;
            int v = Integer.parseInt(p[i]);
            if (v != -1) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            } else {
                root = u;
            }
        }
        map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            map.put(k, map.getOrDefault(k, 0) + v);
        }
        scores = new int[n + 1];
        dfs(root, -1, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(scores[i]).append(" ");
        }
        System.out.print(sb);
    }

    private static void dfs(int u, int p, int score) {
        score += Optional.ofNullable(map.get(u)).orElse(0);
        for (int v : adj.get(u)) {
            if (v == p) {
                continue;
            }
            dfs(v, u, score);
        }
        scores[u] = score;
    }
}

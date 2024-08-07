package baekjoon.x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1068 {
    static List<List<Integer>> adj = new ArrayList<>();
    static int answer = 0;
    static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int u = 0; u < n; u++) {
            int v = Integer.parseInt(input[u]);
            if (v == -1) {
                root = u;
                continue;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int delete = Integer.parseInt(br.readLine());
        if (delete == root) {
            System.out.println(answer);
            return;
        }
        for (int i = 0; i < n; i++) {
            adj.get(i).remove(Integer.valueOf(delete));
        }
        adj.get(delete).clear();
        dfs(root, -1);
        System.out.println(answer);
    }

    private static void dfs(int u, int p) {
        int count = 0;
        if (adj.get(u).isEmpty() && u != root) {
            return;
        }
        for (int v : adj.get(u)) {
            if (v == p) {
                continue;
            }
            count++;
            dfs(v, u);
        }
        if (count == 0) {
            answer++;
        }
    }
}

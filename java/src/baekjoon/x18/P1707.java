package baekjoon.x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1707 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] ve = br.readLine().split(" ");
        int v = Integer.parseInt(ve[0]);
        int e = Integer.parseInt(ve[1]);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        StringBuilder sb = new StringBuilder();
        int[] nodeColors = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            if (nodeColors[i] == 0) {
                if (!dfs(i, 1, nodeColors, adj)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    private static boolean dfs(int u, int color, int[] nodeColors, List<List<Integer>> adj) {
        nodeColors[u] = color;
        for (Integer v : adj.get(u)) {
            if (nodeColors[u] == nodeColors[v]) {
                return false;
            }
            if (nodeColors[v] != 0) {
                continue;
            }
            if (!dfs(v, color * -1, nodeColors, adj)) {
                return false;
            }
        }
        return true;
    }
}

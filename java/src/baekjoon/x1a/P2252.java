package baekjoon.x1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        List<List<Integer>> adj = new ArrayList<>();
        int[] deg = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            adj.get(a).add(b);
            deg[b] += 1;
        }
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) {
                que.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            Integer from = que.poll();
            sb.append(from).append(" ");
            for (int to : adj.get(from)) {
                deg[to]--;
                if (deg[to] == 0) {
                    que.offer(to);
                }
            }
        }
        System.out.println(sb);
    }
}

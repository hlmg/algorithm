package baekjoon.x1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2623 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] deg = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int count = sc.nextInt();
            int from = sc.nextInt();
            for (int j = 0; j < count - 1; j++) {
                int to = sc.nextInt();
                adj.get(from).add(to);
                deg[to] += 1;
                from = to;
            }
        }
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) {
                que.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            int cur = que.poll();
            sb.append(cur).append("\n");
            for (int next : adj.get(cur)) {
                deg[next] -= 1;
                if (deg[next] == 0) {
                    que.offer(next);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (deg[i] != 0) {
                System.out.print(0);
                return;
            }
        }
        System.out.print(sb);
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new IllegalArgumentException();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

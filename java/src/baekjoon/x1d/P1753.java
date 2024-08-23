package baekjoon.x1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {
    public static void main(String[] args) {
        final int INF = 20_000 * 10;
        FastScanner sc = new FastScanner();
        int v = sc.nextInt();
        int e = sc.nextInt();
        int k = sc.nextInt();
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            adj.get(sc.nextInt()).add(new Pair(sc.nextInt(), sc.nextInt()));
        }
        int[] d = new int[v + 1];
        Arrays.fill(d, INF);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        d[k] = 0;
        pq.offer(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair c = pq.poll();
            if (c.w != d[c.u]) {
                continue;
            }
            for (Pair n : adj.get(c.u)) {
                if (d[n.u] <= d[c.u] + n.w) {
                    continue;
                }
                d[n.u] = d[c.u] + n.w;
                pq.offer(new Pair(n.u, d[n.u]));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (d[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(d[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static class Pair {
        int u;
        int w;

        public Pair(int u, int w) {
            this.u = u;
            this.w = w;
        }
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

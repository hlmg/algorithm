package baekjoon.x1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1238 {
    public static void main(String[] args) {
        final int INF = 1000 * 100;
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        List<List<Pair>> adj = new ArrayList<>();
        List<List<Pair>> inboundAdj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            inboundAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Pair(v, w));
            inboundAdj.get(v).add(new Pair(u, w));
        }
        int[] d1 = new int[n + 1];
        int[] d2 = new int[n + 1];
        Arrays.fill(d1, INF);
        Arrays.fill(d2, INF);
        djk(d1, adj, x);
        djk(d2, inboundAdj, x);
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, (d1[i] + d2[i]));
        }
        System.out.print(answer);
    }

    private static void djk(int[] d, List<List<Pair>> adj, int x) {
        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        pq.offer(new Pair(x, 0));
        d[x] = 0;
        while (!pq.isEmpty()) {
            Pair c = pq.poll();
            if (d[c.v] != c.w) {
                continue;
            }
            for (Pair nxt : adj.get(c.v)) {
                if (d[nxt.v] <= d[c.v] + nxt.w) {
                    continue;
                }
                d[nxt.v] = d[c.v] + nxt.w;
                pq.offer(new Pair(nxt.v, d[nxt.v]));
            }
        }
    }

    private static class Pair {
        int v;
        int w;

        public Pair(int v, int w) {
            this.v = v;
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

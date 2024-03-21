package baekjoon.x1d;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11779 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, List<Edge>> edges = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int key = sc.nextInt();
            edges.putIfAbsent(key, new ArrayList<>());
            edges.get(key).add(new Edge(sc.nextInt(), sc.nextInt()));
        }
        int departure = sc.nextInt();
        int arrival = sc.nextInt();
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(node -> node.distance));
        pq.offer(new Node(departure, 0, List.of(departure)));

        boolean[] visited = new boolean[1001];
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.number]) {
                continue;
            }
            visited[node.number] = true;
            if (node.number == arrival) {
                print(node);
                return;
            }
            if (!edges.containsKey(node.number)) {
                continue;
            }
            for (Edge edge : edges.get(node.number)) {
                if (visited[edge.node]) {
                    continue;
                }
                pq.offer(node.next(edge));
            }
        }
    }

    private static void print(Node node) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write(node.distance + "\n");
            bw.write(node.routes.size() + "\n");
            for (Integer route : node.routes) {
                bw.write(route + " ");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Node {
        int number;
        long distance;
        List<Integer> routes;

        public Node(int number, long distance, List<Integer> routes) {
            this.number = number;
            this.distance = distance;
            this.routes = routes;
        }

        public Node next(Edge edge) {
            List<Integer> routes = new ArrayList<>(this.routes);
            routes.add(edge.node);
            return new Node(edge.node, distance + edge.weight, routes);
        }
    }

    private static class Edge {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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

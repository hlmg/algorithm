package baekjoon.x1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1753 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int v = sc.nextInt();
        int e = sc.nextInt();
        int k = sc.nextInt();

        Map<Integer, List<Edge>> edges = new HashMap<>();
        for (int i = 0; i < e; i++) {
            int key = sc.nextInt();
            edges.putIfAbsent(key, new ArrayList<>());
            edges.get(key).add(new Edge(sc.nextInt(), sc.nextInt()));
        }

        int[] answer = new int[v + 1];
        Arrays.fill(answer, -1);
        Queue<Node> nodes = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        nodes.add(new Node(k, 0));

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            int number = node.number;
            int distance = node.distance;
            if (answer[number] != -1) {
                continue;
            }
            answer[number] = distance;
            if (!edges.containsKey(number)) {
                continue;
            }
            for (Edge edge : edges.get(number)) {
                int to = edge.to;
                int weight = edge.weight;
                if (answer[to] != -1) {
                    continue;
                }
                nodes.offer(new Node(to, weight + distance));
            }
        }

        for (int i = 1; i <= v; i++) {
            int result = answer[i];
            if (result == -1) {
                System.out.println("INF");
            } else {
                System.out.println(result);
            }
        }
    }

    private static class Node {
        int number;
        int distance;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }
    }

    private static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
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

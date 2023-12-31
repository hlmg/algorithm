package baekjoon.x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10866 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        MyDeque que = new MyDeque();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            switch (command) {
                case "push_front":
                    que.pushFront(sc.nextInt());
                    break;
                case "push_back":
                    que.pushBack(sc.nextInt());
                    break;
                case "pop_front":
                    System.out.println(que.popFront());
                    break;
                case "pop_back":
                    System.out.println(que.popBack());
                    break;
                case "size":
                    System.out.println(que.size());
                    break;
                case "empty":
                    System.out.println(que.empty());
                    break;
                case "front":
                    System.out.println(que.front());
                    break;
                case "back":
                    System.out.println(que.back());
                    break;
            }
        }
    }

    private static class MyDeque {
        Node first;
        Node last;
        int size;

        public void pushFront(int x) {
            Node node = new Node(x);
            if (size == 0) {
                first = node;
                last = node;
            } else {
                first.previous = node;
                node.next = first;
                first = node;
            }
            size++;
        }

        public void pushBack(int x) {
            Node node = new Node(x);
            if (size == 0) {
                first = node;
                last = node;
            } else {
                last.next = node;
                node.previous = last;
                last = node;
            }
            size++;
        }

        public int popFront() {
            if (size == 0) {
                return -1;
            }
            int value = first.value;
            first = first.next;
            size--;
            return value;
        }

        public int popBack() {
            if (size == 0) {
                return -1;
            }
            int value = last.value;
            last = last.previous;
            size--;
            return value;
        }

        public int size() {
            return size;
        }

        public int empty() {
            if (size == 0) {
                return 1;
            }
            return 0;
        }

        public int front() {
            if (size == 0) {
                return -1;
            }
            return first.value;
        }

        public int back() {
            if (size == 0) {
                return -1;
            }
            return last.value;
        }

        private static class Node {
            int value;
            Node previous;
            Node next;

            public Node(int value) {
                this.value = value;
            }
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

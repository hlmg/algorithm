package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3190 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            map[y - 1][x - 1] = 1;
        }
        int l = sc.nextInt();
        Queue<Command> commands = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            Command command = new Command(sc.nextInt(), sc.next());
            commands.offer(command);
        }

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int dir = 0;
        int time = 0;
        int currentY = 0;
        int currentX = 0;
        map[currentY][currentX] = -1;
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(0);
        que.offer(0);
        while (true) {
            time++;
            int ny = currentY + dy[dir];
            int nx = currentX + dx[dir];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                break;
            }
            if (map[ny][nx] == -1) {
                break;
            }
            if (map[ny][nx] == 0) {
                map[que.poll()][que.poll()] = 0;
            }
            currentY = ny;
            currentX = nx;
            map[currentY][currentX] = -1;
            que.offer(currentY);
            que.offer(currentX);

            if (!commands.isEmpty() && commands.peek().x == time) {
                String c = commands.poll().c;
                if (c.equals("L")) {
                    dir = dir - 1;
                    if (dir == -1) {
                        dir = 3;
                    }
                } else {
                    dir = (dir + 1) % 4;
                }
            }
        }
        System.out.println(time);
    }

    private static class Command {
        int x;
        String c;

        public Command(int x, String c) {
            this.x = x;
            this.c = c;
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

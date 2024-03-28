package baekjoon.implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class P4673 {
    public static void main(String[] args) throws IOException {
        boolean[] visited = new boolean[10000 + 1];
        for (int i = 1; i < 10000; i++) {
            d(i, visited);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= 10000; i++) {
            if (!visited[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void d(int number, boolean[] visited) {
        int next = getNext(number);
        if (next > 10000 || visited[next]) {
            return;
        }
        visited[next] = true;
        d(next, visited);
    }

    private static int getNext(int number) {
        int next = number;
        while (number > 0) {
            next += number % 10;
            number = number / 10;
        }
        return next;
    }
}

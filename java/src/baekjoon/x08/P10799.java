package baekjoon.x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int answer = 0;
        int count = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == '(' && input[i + 1] == ')') {
                answer += count;
                i++;
                continue;
            }

            if (input[i] == ')') {
                count--;
                continue;
            }

            if (input[i] == '(') {
                count++;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

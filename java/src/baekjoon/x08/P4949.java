package baekjoon.x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        while (true) {
            String answer = "yes";
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                    continue;
                }

                if (c != ')' && c != ']') {
                    continue;
                }

                if (stack.isEmpty()) {
                    answer = "no";
                    break;
                }

                Character pop = stack.pop();
                if (!isMatch(pop, c)) {
                    answer = "no";
                    break;
                }
            }
            if (!stack.isEmpty()) {
                answer = "no";
            }
            System.out.println(answer);
            stack.clear();
        }
    }

    private static boolean isMatch(Character pop, char c) {
        return (pop == '(' && c == ')') || (pop == '[' && c == ']');
    }
}

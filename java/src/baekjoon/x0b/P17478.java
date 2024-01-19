package baekjoon.x0b;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P17478 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        rec(0);
        bw.close();
    }

    public static void rec(int depth) throws IOException {
        if (depth > n) {
            return;
        }

        String prefix = "____".repeat(depth);
        bw.write(String.format("%s\"재귀함수가 뭔가요?\"\n", prefix));
        if (depth == n) {
            bw.write(String.format("%s\"재귀함수는 자기 자신을 호출하는 함수라네\"\n", prefix));
        } else {
            bw.write(String.format("%s\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n", prefix));
            bw.write(String.format("%s마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n", prefix));
            bw.write(String.format("%s그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n", prefix));
        }
        rec(depth + 1);
        bw.write(String.format("%s라고 답변하였지.\n", prefix));
    }
}

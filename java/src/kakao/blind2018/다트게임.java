package kakao.blind2018;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다트게임 {
    public int solution(String dartResult) {
        int answer = 0;
        Pattern pattern = Pattern.compile("(\\d*)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);

        int pre = 0;
        while (matcher.find()) {
            int point = Integer.parseInt(matcher.group(1));
            String bonus = matcher.group(2);
            String option = matcher.group(3);

            if (bonus.equals("D")) {
                point = (int) Math.pow(point, 2);
            } else if (bonus.equals("T")) {
                point = (int) Math.pow(point, 3);
            }

            if (option.equals("*")) {
                answer += pre;
                point *= 2;
            } else if (option.equals("#")) {
                point *= -1;
            }

            pre = point;
            answer += point;
        }
        return answer;
    }

    public static void main(String[] args) {
        다트게임 solution = new 다트게임();
        System.out.println(solution.solution("1S2D*3T"));
        System.out.println(solution.solution("1D2S#10S"));
    }
}

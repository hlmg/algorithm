package kakao.blind2019;

import java.util.*;

class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();

        for (String row : record) {
            String[] input = row.split(" ");
            String command = input[0];
            String id = input[1];

            if (command.equals("Enter") || command.equals("Change")) {
                map.put(id, input[2]);
            }
        }

        List<String> messages = new ArrayList<>();

        String ENTER_MESSAGE = "%s님이 들어왔습니다.";
        String LEAVE_MESSAGE = "%s님이 나갔습니다.";
        for (String row : record) {
            String[] input = row.split(" ");
            String command = input[0];
            String id = input[1];

            if (command.equals("Enter")) {
                messages.add(String.format(ENTER_MESSAGE, map.get(id)));
            } else if (command.equals("Leave")) {
                messages.add(String.format(LEAVE_MESSAGE, map.get(id)));
            }
        }
        String[] answer = new String[messages.size()];

        for (int i = 0; i < messages.size(); i++) {
            answer[i] = messages.get(i);
        }

        return answer;
    }
}

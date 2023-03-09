import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 1; i < numbers.length; i++) {

            while (!stack.isEmpty()) {
                int idx = stack.pop();

                if (numbers[i] > numbers[idx]) {
                    answer[idx] = numbers[i];

                } else {
                    stack.push(idx);
                    break;
                }

            }
            stack.push(i);
        }


        return answer;
    }
}
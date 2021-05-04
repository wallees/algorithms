package programmers;

public class P43165 {
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        int index = 0;
        bfs(numbers, 0, 0, target);
        return answer;
    }
    public void bfs(int[] numbers, int index, int total, int target) {

        if (index < numbers.length) {
            bfs(numbers, index+1, total+numbers[index], target);
            bfs(numbers, index+1, total+(numbers[index]*(-1)), target);
        } else {
            if(total == target) {
                answer += 1;
            }
        }
    }
}

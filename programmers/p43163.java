package programmers;

public class P43163 {
    int answer = 0; // 몇번만에 찾았는지?
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        for(int i=0; i<visited.length; i++) {
            visited[i] = false;
        }

        for(int i=0; i<words.length; i++) {
            if (target.equals(words[i])) {

                dfs(visited, words, begin, target, 0);

                return answer;
            }
        }
        return 0;           // 아예 없을 때
    }

    public void dfs(boolean[] visited, String[] words, String begin, String target, int count) {
        if(begin.equals(target)) {
            answer = count;
            return;
        }
        for(int i=0; i<words.length; i++) {
            if(visited[i] == false && countSameWord(begin, words[i])) {
                // System.out.println(words[i] + " " + count);
                visited[i] = true;
                dfs(visited, words, words[i], target, count+1);
                visited[i] = false;
            }
        }
    }

    // 한글자만 빼고 다 똑같은 문자인지 확인
    public boolean countSameWord(String word, String begin) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == begin.charAt(i)) {
                count++;
            }
        }
        if (count == word.length() - 1) {
            return true;
        }
        return false;
    }
}

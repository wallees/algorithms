package programmers;

public class P43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            visited[i] = false;
        }

        for(int i=0; i<n; i++) {
            // 갔는지 안갔는지 확인
            if(visited[i] == false) {
                answer++;
                dfs(computers, i, visited);
            }
        }
        return answer;
    }

    public void dfs(int[][] computers, int node, boolean[] visited) {
        visited[node] = true;
        for(int i=0; i<computers.length; i++) {
            if(visited[i] == false && computers[node][i] == 1) {
                dfs(computers, i, visited);
            }
        }
    }
}

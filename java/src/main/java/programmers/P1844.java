package programmers;

import java.util.*;

public class P1844 {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println((new Solution_BFS()).solution(maps));
    }
}

class Solution_BFS {
    public int solution(int[][] maps) {
        int answer = 0;

        int[][] dirs    = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int[][] steps   = new int[maps.length][maps[0].length];

        for(int i=0; i<steps.length; i++) {
            for (int j=0; j<steps[i].length; j++) {
                steps[i][j] = -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        steps[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            for(int[] dir : dirs) {
                int row = point[0] + dir[0];
                int col = point[1] + dir[1];
                if (row >= 0 && col >= 0 && row < maps.length && col < maps[0].length) {
                    if (maps[row][col] == 1 && steps[row][col] == -1) { // 갈수 있는데 아직 안갔다면?
                        steps[row][col] = steps[point[0]][point[1]] + 1;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }
        return steps[maps.length-1][maps[0].length-1];
    }

//    public void bfs(int[][] maps, int _row, int _col, int count) {
//        /*방향지시등*/   int[][]         dirs    = {{-1,0}, {1,0}, {0,-1}, {0,1}};
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{_row, _col});
//
//        while(!queue.isEmpty()) {
//            int[] point = queue.poll();
//            for(int[] dir : dirs) {
//                int row = point[0] + dir[0];
//                int col = point[1] + dir[1];
//                if (row >= 0 && col >= 0 && row < maps.length && col < maps[0].length) {
//
//                }
//            }
//        }
//
//    }
}








class Solution_DFS {
    public int solution(int[][] maps) {
        int answer = 0;
        /*방문경로 맵*/  boolean[][]     visited = createVisited(maps);
        /*방향지시등*/   int[][]         dirs    = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        /*이동횟수리스트*/ List<Integer>   countList = new ArrayList<>();

        dfs(maps, visited, dirs, countList, 0, 0, 0);

        if (countList.size() == 0) {
            answer = -1;
        } else {
            Collections.sort(countList);
            answer = countList.get(0);
        }
        return answer;

    }

    public void dfs(int[][] maps, boolean[][] visited, int[][] dirs, List<Integer> countList, int _row, int _col, int count) {

        if (_row == maps.length-1 && _col == maps[0].length-1) {
            countList.add(count+1);
            return;
        }

        for (int i=0; i<dirs.length; i++) {
            int row = _row + dirs[i][0];
            int col = _col + dirs[i][1];
            if (row >= 0 && col >= 0 && row < maps.length && col < maps[0].length) {
                if (maps[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    dfs(maps, visited, dirs, countList, row, col, count + 1);
                    visited[row][col] = false;
                }
            }
        }
        return;

    }


    // 방문경로 저장하는 맵 생성
    public boolean[][] createVisited(int[][] maps) {
        return new boolean[maps.length][maps[0].length];
    }

    // 이동가능경로 갯수 세기
    public static int getMovable(int[][] maps) {
        int count = 0;
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[i].length; j++) {
                if (maps[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}

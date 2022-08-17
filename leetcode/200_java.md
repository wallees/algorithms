# 200. Number of Islands

## Summary

🙇‍♂️ URL : https://leetcode.com/problems/number-of-islands/  
🤷‍♂️ Difficulty: Medium  
💆‍♂️ Submissions

- Runtime: 13 ms, faster than 14.95% of Java online submissions for Number of Islands.
- Memory Usage: 54.2 MB, less than 84.54% of Java online submissions for Number of Islands.

## Source code

```java
class Solution {
    int answer = 0;
    
    public int numIslands(char[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    answer++;
                    grid[i][j] = '0';
                    dfs(i, j, grid);
                }   
            }
        }
        return answer;
    }
    
    public void dfs(int row, int col, char[][] grid) {
        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        
        for(int i=0; i<dir.length; i++) {
            int ny = col + dir[i][1];
            int nx = row + dir[i][0];
            
            if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny] == '1') {
                grid[nx][ny] = '0';
                dfs(nx, ny, grid);
            }
        }
    }
}
```

## How to Approach

섬을 나타내는 '1'을 '0'으로 지워나가는 묶음을 출력해준다.  

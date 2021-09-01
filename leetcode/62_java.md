# 62. Unique Paths

## Summary

🙇‍♂️ URL : https://leetcode.com/problems/unique-paths/  
🤷‍♂️ Difficulty: Medium  
💆‍♂️ Submissions

- RunTime: 0 ms, faster than 100.00% of Java online submissions
- Memory Usage: 35.7 MB, less than 68.22% of Java online submissions

## Source code

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 || j == 0) {
                    map[i][j] = 1;    
                } else {
                    map[i][j] = map[i-1][j] + map[i][j-1];           
                }
            }
        }
        return map[m-1][n-1];
    }
}
```

## How to Approach

처음엔 DFS로 접근하였는데 Time Limit Exceed -> BFS로 접근하였는데도 Time Limit Exceed가 나왔다.

곰곰히 생각해보니 DP(Dynamic Programming)으로 접근해야 할 것 같았다. 오랜만에 사용해봤는데, 생각보다 어렵지 않았다. 

그리고 자세히보니 문제에서 이미 "오른쪽 혹은 아래로만 이동" 이라는 대놓고 DP를 쓰라는 힌트를 주고 있었다. 

전체 이동해야 하는 맵을 만들어주고, 맨윗칸(m=0)과 맨왼쪽칸(n=0)인 곳은 모두 1번에 갈 수 있는 곳이라고 표시해주었다. 나머지 그 내부에 있는 경로들은 그 전까지 이동한 거리(왼쪽칸과 윗쪽칸)들의 합이라고 생각하고 DP를 구성해주었다.

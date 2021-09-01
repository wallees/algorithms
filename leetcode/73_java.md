# 73. Set Matrix Zeroes

## Summary
🙇‍♂️ URL : https://leetcode.com/problems/set-matrix-zeroes/  
🤷‍♂️ Difficulty: Medium  
💆‍♂️ Submissions
- RunTime: 1 ms, Your runtime beats 92.73 % of java submissions
- Memory Usage: 40.7 MB, Your memory usage beats 48.25 % of java submissions

## Source code
```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int[] _x = new int[matrix.length];
        int[] _y = new int[matrix[0].length];

        int index = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    _x[i] = 1;
                    _y[j] = 1;
                }
            }
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (_x[i] == 1 || _y[j] == 1) {
                    matrix[i][j] = 0;                    
                }
            }
        }
    }
}
```

## How to Approach
값이 0인 x,y 좌표를 구하고 각 x, y 좌표에 해당하는 값들을 모두 0으로 바꿔주면 된다.  
단, 먼저 어떤 좌표값이 0인지 구해놓고 한번에 변경해야 한다. 안그러면 변경되는 도중 값이 업데이트되서 결국 모든 배열의 모든 값이 0이 될 것이다.

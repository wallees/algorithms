# 268. Missing Number

## Summary

🙇‍♂️ URL : https://leetcode.com/problems/missing-number/  
🤷‍♂️ Difficulty: Medium  
💆‍♂️ Submissions

- RunTime: 0 ms, faster than 100.00% of Java online submissions
- Memory Usage: 38.9 MB, less than 95.95% of Java online submissions

## Source code

```java
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i=1; i<=nums.length; i++) {
            sum += i;
        }
        for(int i=0; i<nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
```

## How to Approach

너무 쉽게 풀었다. 배열의 크기만큼 연속된 숫자가 있고, 이 중 하나의 숫자가 없는데 그게 무엇인지 물어보는 문제다. 

추가공간은 O(1)로, Runtime은 O(n)으로 요구하고 있어서 추가적인 배열이나 공간은 사용하지 않고 문제를 풀었다. 1부터 n까지의 합에서 실제 배열에 들어있는 값들을 순차적으로 빼서 남은 숫자가 배열에 없는 숫자라는 방식으로 구했다.

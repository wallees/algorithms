# 189. Rotate Array

## Summary

🙇‍♂️ URL : https://leetcode.com/problems/rotate-array/  
🤷‍♂️ Difficulty: Medium  
💆‍♂️ Submissions

- RunTime: 1 ms, faster than 51.90% of Java online submissions
- Memory Usage: 55.9 MB, less than 40.60% of Java online submissions

## Source code

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int rsize = k%nums.length;
        int[] temp = new int[rsize];

        for(int i=0; i<rsize; i++) {
            temp[i] = nums[nums.length-(rsize)+i];
        }

        // 6-(k%nums.length) -> 6
        // 6-(k%nums.length)-1 -> 6-1
        // 6-(k%nums.length)-2 -> 6-2
        // 6-(k%nums.length)-3 -> 6-3
        for(int i=0; i<nums.length-rsize; i++) {
            nums[nums.length-1-i] = nums[nums.length-1-rsize-i];
        }
        for(int i=0; i<temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}
```

## How to Approach

주어진 배열을 k만큼 로테이션하는 문제로, 로테이션 방향은 뒤에서 앞으로 이동한다. 0번부터 n-1번 방향으로 데이터가 이동한다고 할 때, 마치 Queue와 동일한 개념을 갖는다. 이에 큐를 이용하여 문제를 해결하려고 했는데, 문제의 요건에 "Could you do it in-place with O(1) extra space?"가 있어서 추가적인 배열을 사용하지 않고 문제를 풀어보려고 열심히 노력해보았다.

하지만 쉽지 않았고, 결국 temp 배열(extra space를 O(n)만큼 더 써버림)을 두고 이를 구현하였다. k가 배열의 크기보다 클 경우 불필요한 반복횟수만 증가하므로 k%(nums.length)를 이용하여 배열의 크기보다 작게 순환하도록 하였고, temp 배열에는 순환된(앞으로 이동한) 값들을 먼저 배치하고 앞에서 뒤로 이동한 값들을 나중에 넣어주었다.

최종적으로 반환되어야 할 값은 nums 배열이기 때문에, 만들어진 temp 배열의 내용을 다시 nums 배열로 복사해주었다.

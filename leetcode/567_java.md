# 567. Permutation in String

## Summary

🙇‍♂️ URL : https://leetcode.com/problems/permutation-in-string/   
🤷‍♂️ Difficulty: Medium  
💆‍♂️ Submissions

- Runtime: 316 ms, faster than 14.70% of Java online submissions for Permutation in String
- Memory Usage: 117.6 MB, less than 5.14% of Java online submissions for Permutation in String

## Source code

```java
class Solution {
    
    public boolean checkInclusion(String s1, String s2) {
               
        int[] s1Array = getArray(s1);
        for(int i=0; i<s2.length()-s1.length()+1; i++) {
            int[] s2subArray = getArray(s2.substring(i, i+s1.length()));
            if(isSame(s1Array, s2subArray)) {
                return true;
            }
        }     
        return false;
        
    }
    
    public boolean isSame(int[] arr1, int[] arr2) {
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public int[] getArray(String str) {
        int[] alphabets = new int[30];
        char[] array = str.toCharArray();
        for(int i=0; i<array.length; i++) {
            alphabets[array[i]-97]++;
        }
        return alphabets;
    }
}
```

## How to Approach

처음에는 dfs로 접근했지만, Time Limit Exceeded가 발생하였음.  
그래서 'Substring에 있는 알파벳들의 갯수 == s1에 있는 알파벳의 갯수'로 다시 접근하여 문제 해결. 속도나 성능면에서는 개선이 더 필요할 것으로 보임.

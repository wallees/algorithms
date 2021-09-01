# 49. Group Anagrams

## Summary
🙇‍♂️ URL : https://leetcode.com/problems/group-anagrams/  
🤷‍♂️ Difficulty: Medium  
💆‍♂️ Submissions
- RunTime: 6 ms, Your runtime beats 77.03 % of java submissions
- Memory Usage: 42 MB, Your memory usage beats 76.68 % of java submissions  

## Source code
```java
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        HashMap<String,List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);

            if (!map.containsKey(sortedStr)) {
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                map.put(sortedStr, strList);
            } else {
                List<String> strList = map.get(sortedStr);
                strList.add(strs[i]);
                map.put(sortedStr, strList);
            }

        }

        for(List<String> strList : map.values()) {
            result.add(strList);
        }


        return result;
    }
}
```

## How to Approach
anagram을 확인할 수 있는 가장 쉬운 방법은, 주어진 문자열을 오름차순 했을 때 동일한 값이 나오는지 여부를 확인하는 것이다.
각 행마다 존재하는 문자열을 하나씩 오름차순한 후, 이를 해시맵에 저장하여 최종적으로 해시맵에 있는 값들을 출력해주었다.

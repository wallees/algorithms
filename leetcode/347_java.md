# 347. Top K Frequent Elements

## Summary

🙇‍♂️ URL : https://leetcode.com/problems/top-k-frequent-elements/  
🤷‍♂️ Difficulty: Medium  
💆‍♂️ Submissions

- RunTime: 24 ms, faster than 5.19% of Java online submissions
- Memory Usage: 41 MB, less than 98.15% of Java online submissions

## Source code

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.replace(nums[i], map.get(nums[i]) + 1);
            }
        }

        if(map.size() == 1) {
            result[0] = nums[0];
            return result;
        }

        // value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        // 순서유지를 위해 LinkedHashMap을 사용
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>(); 
        for(Iterator<Map.Entry<Integer, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<Integer, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> elem : sortedMap.entrySet()){
            if(count == k) {
                break;
            }
            result[count] = elem.getKey();
            count++;
        }
        return result;
    }
}
```

## How to Approach

분명 더 빠르게 해결하는 방법이 있을텐데, 이번에는 빠르게 풀어보자는 생각으로만 접근해서 깊이 생각하지는 못했다.

주어진 정수배열에서 상위 k번째까지의 높은 빈도수를 갖는 정수 k개를 배열로 만들어서 반환하는 문제다. 

1) 먼저 정수를 정렬해준다 -> 같은 숫자가 연속적으로 나오도록

2) 각 숫자별로 HashMap에 등록해준다 -> {key = 숫자, value = 빈도수}

3) HashMap을 value의 크기에 따라 내림차순으로 정렬해준다 -> Collections.sort 사용을 위한 LinkedList 사용

4) 정렬된 값을 순서대로 LinkedHashMap에 등록

5) LinkedHashMap을 순서대로 접근하면서, k번째까지의 key 값을 배열로 담아서 반환

여기서 3)번과 4)번에 대한 소스코드는 [인터넷](https://cornswrold.tistory.com/114)에서 복붙했다. Comparator를 이용한 정렬 커스터마이즈가 아직 손에 익지 않았고, LinkedList에 HashMap을 옮겨야 정렬이 가능하다는 것도 정확히 인지하지 못했다. 아직 노력이 많이 필요한 듯;

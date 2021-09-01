# 2. Add Two Numbers

## Summary

🙇‍♂️ URL : https://leetcode.com/problems/add-two-numbers/  
🤷‍♂️ Difficulty: Medium  
💆‍♂️ Submissions

- RunTime: 13 ms, faster than 5.11% of Java online submissions
- Memory Usage: 39.7 MB, less than 7.49% of Java online submissions

## Source code

```java
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String vl1 = "";
        String vl2 = "";

        // l1을 문자열 형태로 변환
        while(l1.next != null) {
            vl1 += Integer.toString(l1.val);
            l1 = l1.next;
        }
        vl1 += Integer.toString(l1.val);

        // l2를 문자열 형태로 변환
        while(l2.next != null) {
            vl2 += Integer.toString(l2.val);
            l2 = l2.next;
        }
        vl2 += Integer.toString(l2.val);

        // l1, l2를 reverse
        StringBuffer sb = new StringBuffer(vl1); 
        String reversedl1 = sb.reverse().toString();
        sb = new StringBuffer(vl2); 
        String reversedl2 = sb.reverse().toString();

        // reverse된 l1, l2를 더해줌
        BigInteger bigl1 = new BigInteger(reversedl1);
        BigInteger bigl2 = new BigInteger(reversedl2);
        bigl1 = bigl1.add(bigl2);
        String sumStr = bigl1.toString();

        ListNode node = new ListNode(sumStr.charAt(0) - '0');
        ListNode newNode = null;
        for(int i=1; i<sumStr.length(); i++) {
            newNode = new ListNode(sumStr.charAt(i) - '0', node);
            node = newNode;
        }
        return node;
    }
}
```

## How to Approach

그냥 풀었다. 최적화 이런거 생각 안하고 머리속에 떠오르는대로 풀어서 그런가 측정결과가 만족스럽지는 못하다.

문제 자체는 굉장히 간단한데, 주어진 두개의 Singly Linked List를 각각 역순으로 순회하면서 만들어진 두 숫자를 더해서 나온 값을 역순되지 않은 본래의 Singly Linked List 형태로 반환해주면 된다. 

List의 길이가 30자리만 넘어도 long으로 해결이 안되므로, BigInteger를 추가로 선언해서 해결하였다.

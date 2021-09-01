# 100. Same Tree

## Summary
🙇‍♂️ URL : https://leetcode.com/problems/same-tree/  
🤷‍♂️ Difficulty: Easy  
💆‍♂️ Submissions
- RunTime: 1 ms, faster than 100.00% of Java online submissions
- Memory Usage: 37 MB, less than 11.30% of Java online submissions

## Source code
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    String ps = "";

    public boolean isSameTree(TreeNode p, TreeNode q) {


        preOrderTraversal(p);
        String qs = new String(ps);
        ps = "";
        preOrderTraversal(q);

        if(ps.equals(qs)) {
            return true;
        }
        return false;
    }

    public void preOrderTraversal(TreeNode node) {
        if (node != null) {
            ps += Integer.toString(node.val);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
        else {
            ps += "n";
        }
    }
}
```

## How to Approach
클린코드 없이 그냥 생각나는대로 작성해보았다.  
어차피 트리구조가 완전히 동일한 경우만 확인하면 되므로, 전위순회로 해서 모든 값을 문자열화 시켜서 비교했다. 자식노드가 없는 경우에는 n을 더해줘서 공란도 동일하게 체크되도록 하였다.

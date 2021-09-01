# 9. Palindrome Number

## Summary
🙇‍♂️ URL : https://leetcode.com/problems/palindrome-number/  
🤷‍♂️ Difficulty: Easy  
💆‍♂️ Submissions
- RunTime:  16 ms, faster than 58.54% of Go online submissions for Palindrome Number
- Memory Usage: 5.2 MB, less than 55.13% of Go online submissions for Palindrome Number   

## Source code
```go
func isPalindrome(x int) bool {
    if x < 0 {
        return false
    }

    strnum := strconv.Itoa(x)

    for i:=0; i<=len(strnum)/2; i++ {
        if strnum[i] != strnum[len(strnum)-1-i] {
            return false
        }
    }

    return true
}
```

## How to Approach
Golang을 너무 오랫동안 손 놓아서 계속 풀어본다.  
문제는 굉장히 쉽기 때문에 설명은 생략함

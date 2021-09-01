# 5. Longest Palindromic Substring

## Summary
🙇‍♂️ URL : https://leetcode.com/problems/longest-palindromic-substring/  
🤷‍♂️ Difficulty: Easy  
💆‍♂️ Submissions
- RunTime:  116 ms, faster than 35.20% of Go online submissions for Longest Palindromic Substring
- Memory Usage: 2.8 MB, less than 69.65% of Go online submissions for Longest Palindromic Substring   

## Source code
```go
func longestPalindrome(s string) string {

    result := ""

    for i:=0; i<len(s); i++ {
        partStr := s[i:len(s)] 

        partialStr := getPartialString(partStr)

        if len(partialStr) > len(result) {
            result = partialStr
        }
    }
    return result
}

func getPartialString(s string) string {

    for i:=len(s); i>0; i-- {
        if s[0] == s[i-1] {
            if isPalindrome(s[0:i]) == true {
                return s[0:i]
            }
        }
    }
    return ""
}


func isPalindrome(s string) bool {

    for i:=0; i<=len(s)/2; i++ {
        if s[i] != s[len(s)-1-i] {
            return false
        }
    }
    return true
}
```

## How to Approach
두어달 쯤 거의 매일같이 코딩문제 연습할때에도 이 문제를 못풀었는데, 역시 코딩테스트는 그날의 컨디션과 운빨인거같다.  
지난번에는 Time Limit Exceeded가 계속 떳는데, Java와 Golang의 차이때문인가.. 잘 모르겠다.  
가장 긴 Palindrome을 찾는게 중요하기 때문에 검색의 방향을 역순(끝에서 안쪽으로)으로 진행했고, 그 중 가장 긴 부분 문자열을 출력해주었다.

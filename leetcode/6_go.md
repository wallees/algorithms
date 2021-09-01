# 6. ZigZag Conversion

## Summary
🙇‍♂️ URL : https://leetcode.com/problems/zigzag-conversion/  
🤷‍♂️ Difficulty: Medium  
💆‍♂️ Submissions
- RunTime: 12 ms, faster than 56.07% of Go online submissions for ZigZag Conversion
- Memory Usage: 7.3 MB, less than 24.51% of Go online submissions for ZigZag Conversion  

## Source code
```go
func convert(s string, numRows int) string {

    arr := make([]string, numRows)
    dir := -1
    idx := 0

    if numRows == 1 {
        return s
    }

    for i:=0; i<len(s); i++ {
        // switch direction
        if idx == 0 || (idx+1) % numRows == 0 {
            dir *= -1
        }

        arr[idx] += s[i:i+1]
        idx += dir 
    }

    result := ""

    for i:=0; i<numRows; i++ {
        result += arr[i]
    }
    return result
}
```

## How to Approach
말이 Zigzag지, 결국 배열을 0,1,2,3,2,1,0,1,2,3,2,1,0과 같이 왔다갔다 하면서 저장된 문자열들을 출력해주는 방식이다.  
배열의 인덱스가 아닌 실제 값이 저장되는 인덱스(idx)를 기준으로 가장 앞과 가장 뒤에 있을때마다 방향을 전환해주도록 구현하였다.  
1차원 배열(numRows == 1)일 때에는 굳이 로직을 태우지 않고 바로 문자열 반환이 되도록 하였다.

# 7. Reverse Integer

## Summary

🙇‍♂️ URL : https://leetcode.com/problems/reverse-integer/  
🤷‍♂️ Difficulty: Easy  
💆‍♂️ Submissions

- RunTime: 0 ms, faster than 100.00% of Go online submissions for Reverse Integer
- Memory Usage: 2.2 MB, less than 30.03% of Go online submissions for Reverse Integer

## Source code

```go
func reverse(x int) int {

    negative := 0
    result := 0
    idx := 0

    if x == 0 {
        return 0
    }

    if x < 0 {
        x *= -1
        negative = 1
    }

    numLen := len(strconv.Itoa(x)) - 1

    for {
        e := x / getPow(numLen)
        result += e * getPow(idx)

        if numLen == 0 {
            break;
        }
        x %= getPow(numLen)
        idx++
        numLen--
    }

    if negative == 1 {
        result *= -1
    }


    if result < -1 * int(math.Pow(float64(2), 31)) || result > int(math.Pow(float64(2), 31)) -1 {
        return 0
    }

    return result
}

func getPow(idx int) int {
    return int(math.Pow(float64(10), float64(idx)))
}
```

## How to Approach

Golang을 너무 오랫동안 손 놓아서 한번 풀어보았다.  

문제는 굉장히 쉽기 때문에 설명은 생략함

func solution(n int) int {
    answer := 0
    
    for true {
        if n == 0 {
            break;
        }
        answer += (n % 10)
        n = n/10
    }
    return answer
}
func solution(a []int, b []int) int {
    
    result := 0
    for i:=0; i<len(a); i++ {
        result += (a[i] * b[i])
    }
    return result
}
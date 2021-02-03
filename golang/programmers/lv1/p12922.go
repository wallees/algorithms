func solution(n int) string {
    
    result := ""
    for i:=0; i<n; i++ {
        if i % 2 == 0 {
            result += "수"
        } else {
            result += "박"
        }
    }
    return result
}
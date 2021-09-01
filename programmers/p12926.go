func solution(s string, n int) string {
    runes := []rune(s)
    result := ""
    
    for i:=0; i<len(runes); i++ {
        val := int(runes[i])
        
        for j:=1; j<=n; j++ {
            if val != 32 {
                val += 1
                if val == 91 {
                    val = 65
                } else if val == 123 {
                    val = 97
                }
            }
        }
        result += string(rune(val))
    }
    
    return result
}
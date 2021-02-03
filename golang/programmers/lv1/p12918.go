func solution(s string) bool {
    
    if len(s) != 4 && len(s) != 6 {
        return false
    }
    
    for i:=0; i<len(s); i++ {    
        if s[i] < 48 || s[i] > 57 {
            return false
        }
    }   
    return true
}
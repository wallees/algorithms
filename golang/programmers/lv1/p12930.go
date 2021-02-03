import (
    // "fmt"
    "strings"
)
func solution(s string) string {
    str := strings.Split(s, " ")
    
    result := ""
    
    for i:=0; i<len(str); i++ {
        if i != 0 {
            result += " "
        }
        elem := str[i]
        
        for j:=1; j<=len(elem); j++ {
            estr := elem[j-1:j]
            if j%2 != 0 {
                result += strings.ToUpper(estr)
            } else {
                result += strings.ToLower(estr)
            }
        }
    }
    return result
}
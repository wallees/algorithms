import "strconv"

func solution(seoul []string) string {
    
    for i:=0; i<len(seoul); i++ {
        if seoul[i] == "Kim" {
            return "김서방은 " + strconv.Itoa(i) + "에 있다"
        }
    }
    return ""
}
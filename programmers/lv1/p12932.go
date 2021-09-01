func solution(n int64) []int {
    arr := make([]int, 0)
    for true {
        if n == 0 {
            break;
        }
        arr = append(arr, int(n)%10)
        n = n/10
    }
    return arr
}
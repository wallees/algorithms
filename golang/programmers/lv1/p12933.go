import (
    "sort"
    "math"
)

func solution(n int64) int64 {
    arr := make([]int, 0)
    for true {
        if n == 0 {
            break;
        }
        arr = append(arr, int(n)%10)
        n = n/10
    }
    sort.Slice(arr, func(i,j int) bool {
        return arr[i] > arr[j] 
    })
    
    var result float64 = 0
    for i:=0; i<len(arr); i++ {
        result += float64(arr[i]) * math.Pow(float64(10), float64(len(arr)-i-1))
    }
    return int64(result)
}
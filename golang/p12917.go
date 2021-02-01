import (
	"sort"
)

func solution(s string) string {
	arr := make([]string, 0)

	for i := 0; i < len(s); i++ {
		arr = append(arr, s[i:i+1])
	}
	sort.Sort(sort.Reverse(sort.StringSlice(arr)))
	result := ""
	for i := 0; i < len(arr); i++ {
		result += arr[i]
	}
	return result
}
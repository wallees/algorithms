import "sort"

func solution(arr []int, divisor int) []int {

	resultArr := make([]int, 0)

	for i := 0; i < len(arr); i++ {
		if arr[i]%divisor == 0 {
			resultArr = append(resultArr, arr[i])
		}
	}

	if len(resultArr) == 0 {
		resultArr = append(resultArr, -1)
		return resultArr
	}
	sort.Sort(sort.IntSlice(resultArr))
	return resultArr
}
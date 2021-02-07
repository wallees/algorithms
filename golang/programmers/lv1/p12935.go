import "sort"

// 참고사이트(sorting): http://pyrasis.com/book/GoForTheReallyImpatient/Unit54
// 참고사이트(슬라이스 복사): https://ponyozzang.tistory.com/459

func solution(arr []int) []int {

	newArr := make([]int, 0)

	if len(arr) == 1 {
		newArr = append(newArr, -1)
	} else {
		originalArr := make([]int, len(arr))
		copy(originalArr, arr)
		sort.Sort(sort.IntSlice(arr))
		for i := 0; i < len(originalArr); i++ {
			if originalArr[i] != arr[0] {
				newArr = append(newArr, originalArr[i])
			}
		}
	}
	return newArr
}
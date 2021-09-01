import (
	"sort"
)

func solution(array []int, commands [][]int) []int {

	result := make([]int, 0)
	temp := make([]int, len(array))

	for l := 0; l < len(commands); l++ {
		// slice -> reference 변경이 일어나므로, copy한 후 사용해야 원래 값이 유지된다.
		copy(temp, array)
		result = append(result, getResult(temp, commands[l]))
	}
	return result
}

func getResult(array []int, command []int) int {
	data := array[command[0]-1 : command[1]]
	sort.Slice(data, func(i, j int) bool { return data[i] < data[j] })
	return data[command[2]-1]
}

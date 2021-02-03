func solution(a int, b int) int64 {
	var total int64 = 0
	var i int64 = 0

	x := int64(a)
	y := int64(b)

	if x == y {
		return x
	} else if x < y {
		for i = x; i <= y; i++ {
			total += i
		}
	} else {
		for i = y; i <= x; i++ {
			total += i
		}
	}
	return total
}
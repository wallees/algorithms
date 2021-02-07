func solution(x int) bool {

	original := x
	div := 0

	for true {
		if x == 0 {
			break
		}
		div += (x % 10)
		x = x / 10
	}

	if original%div == 0 {
		return true
	}

	return false
}
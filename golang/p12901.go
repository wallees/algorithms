func solution(a int, b int) string {

	// THU일때 나머지 0을 -1하는 경우가 발생하므로, 처음 시작을 THU로 해주고 나중에 -1 안하면 됨
	day := []string{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"}
	mday := []int{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}

	date := 0
	if a == 1 {
		date += b
	} else {
		for i := 0; i < a-1; i++ {
			date += mday[i]
		}
		date += b
	}
	return day[date%len(day)]
}
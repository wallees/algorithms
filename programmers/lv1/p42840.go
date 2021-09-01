func solution(answers []int) []int {

	userAnswers := [3][40]int{
		{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5},
		{2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5},
		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
	}

	scores := make(map[int]int)
	maxScore := 0

	for i := 0; i < len(userAnswers); i++ {
		scores[i] = getCorrectCount(answers, userAnswers[i])
		if maxScore < scores[i] {
			maxScore = scores[i]
		}
	}

	result := make([]int, 0)

	for i := 0; i < 3; i++ {
		if scores[i] == maxScore {
			result = append(result, i+1)
		}
	}

	return result
}

func getCorrectCount(testAnswer []int, userAnswer [40]int) int {

	testCount := len(testAnswer)
	userCount := len(userAnswer)
	answerCount := 0

	for i := 0; i < testCount; i++ {
		if testAnswer[i] == userAnswer[i%userCount] {
			answerCount += 1
		}
	}

	return answerCount
}
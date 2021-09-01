func solution(n int, lost []int, reserve []int) int {
    stu := make([]int, n+2)
    
    for i:=1; i<len(stu)-1; i++ {
        stu[i] = 1
    }
    for i:=0; i<len(reserve); i++ {
        stu[reserve[i]] = 2
	}
	
	/*
	 * <중요 제한사항 적용>
	 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 
	 * 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 
	 * 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
	 * stu[lost[i]] = 0이 아니고 stu[lost[i]] -= 1로 빼줘야 함
	 */ 
    for i:=0; i<len(lost); i++ {
        stu[lost[i]] -= 1
    }
    
    for i:=1; i<len(stu)-1; i++ {
        prev := i-1
        next := i+1
        if stu[i] == 0 {
            if stu[prev] == 2 {
                stu[prev] = 1
                stu[i] = 1
                continue
            }
            if stu[next] == 2 {
                stu[next] = 1
                stu[i] = 1
                continue
            }
        }
    }
    
    count := 0
    for i:=0; i<len(stu); i++ {
        if stu[i] > 0 {
            count ++
        }
    }
    
    return count
}
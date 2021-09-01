import "sort"

type sortStr struct {
	str    string
	idxStr string
}

func solution(strings []string, n int) []string {

	sstr := make([]sortStr, 0)
	for i := 0; i < len(strings); i++ {
		str := strings[i]
		sstr = append(sstr, sortStr{str, str[n : n+1]})
	}
	sort.Slice(sstr, func(i, j int) bool {
		if sstr[i].idxStr == sstr[j].idxStr {
			return sstr[i].str < sstr[j].str
		}
		return sstr[i].idxStr < sstr[j].idxStr
	})

	result := make([]string, 0)
	for i := 0; i < len(sstr); i++ {
		result = append(result, sstr[i].str)
	}

	return result
}
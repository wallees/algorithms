package main

import (
	"math"
)

func solution(n int64) int64 {
	var i int64
	for i = 1; i <= n; i++ {
		if n == i*i {
			return int64(math.Pow(float64(i+1), 2))
		}
	}
	return -1
}

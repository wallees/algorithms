/* 백준 2455, 지능형 기차 : https://www.acmicpc.net/problem/2455 */

#include <iostream>
using namespace std;

/*
 시뮬레이션 주제의 연습문제입니다.
 오랜만에 알고리즘 문제 풀이를 해보고싶어서 손을 한번 풀고자 해서 풀어봅니다.
 80% 이상의 정답률을 갖습니다.
 그만큼 '매우 쉬운 난이도' 문제이기 때문에, 특별한 설명 없이 바로 문제에 주석을 달겠습니다.
 */

int main(void)
{
    /*
     in: 승차한 사람
     out: 내린 사람
     maximum: 현재까지 기차 안에 존재한 최대 인원 수
     capacity: 현재 기차 안에 존재한 인원 수
     */
    int in;
    int out;
    int maximum = 0;
    int capacity = 0;
    for(int i=0; i<4; i++) {
        cin>>out>>in;
        // 승차한 인원 수를 비교해서 최대 값을 계속 갱신해 나갑니다.
        capacity += (in - out);
        if(maximum < capacity) maximum = capacity;
    }
    cout<<maximum<<endl;
    return 0;
}

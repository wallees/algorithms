/* 백준 2178, 미로 탐색 : https://www.acmicpc.net/problem/2178 */

#include <iostream>
#include <string>
#include <cstring>
using namespace std;

/*
 미로 탐색 문제를 DFS(Depth First Search) 알고리즘으로 풀었습니다.
 이 문제는 DFS 방식으로 풀게 되면 시간 초과가 발생하게 됩니다.
 그러므로 BFS(Breadth First Search) 알고리즘을 사용해야 합니다.
 BFS 알고리즘으로 풀이한 코드 또한 올리겠습니다.
 map : 문제에서 제시한 미로를 나타낸 배열입니다. 최대 크기가 100이라고 문제에서 제시되어 있습니다.
 M : 가로(x)의 크기입니다.
 N : 세로(y)의 크기입니다.
 result : 최종 결과 값 입니다.
 */
int map[100][100];
int M;
int N;
int result = 0;

/*
 void DFS()
 주어진 미로를 DFS 방식을 이용하여 해결해나갑니다.
 */
void DFS(int m, int n, int move) {
    // 만약 x와 y 좌표가 모두 맨 끝에 위치하게 된다면
    // 시작점을 0,0부터 시작하여 순서대로 확인하기 때문에
    // 더이상 확인할 수 있는 곳이 없다는 의미이므로 종료하게 됩니다.
    if((m == M - 1) && (n == N - 1)) {
        if(result > move) result = move;
        return;
    }
    // 현재 위치는 '지나간 곳' 이기 때문에
    // 중복 확인하지 않기 위하여 0, 갈 수 없는 길로 표시합니다.
    map[n][m] = 0;
    
    // 상
    if((n > 0) && map[n-1][m])      DFS(m, n-1, move + 1);
    // 하
    if((n < N - 1) && map[n+1][m])  DFS(m, n+1, move + 1);
    // 좌
    if((m > 0) && map[n][m-1])      DFS(m-1, n, move + 1);
    // 우
    if((m < M -1) && map[n][m+1])   DFS(m+1, n, move + 1);
    
    // 상하좌우 어디로도 갈 수 없다면
    // 지나가지 않은 곳이기 때문에 다시 1로 바꿔줍ㄴ다.
    map[n][m] = 1;
}

int main(void) {
    string input;
    cin>>N>>M;
    result = N * M;     // 결과 값을 먼저 최대값으로 설정해놓습니다.
    
    // 미로의 각 열을 연속된 자연수로 입력받기 때문에
    // 스트링으로 입력받고, 이를 각 열마다 나눠주는 방식으로 진행했습니다.
    for(int i=0; i<N; i++) {
        cin>>input;
        for(int j=0; j<M; j++)  map[i][j] = input.at(j) - 48;
    }
    // DFS 방식으로 [0,0] 행렬부터 이동을 시작합니다.
    DFS(0, 0, 1);
    cout<<result<<endl;
    return 0;
}


// https://www.acmicpc.net/problem/1012

#include <iostream>
#include <vector>
using namespace std;

/*
 M: 배추를 심은 배추 밭의 가로 길이(1<=M<=50)
 N: 배추를 심은 배추 밭의 세로 길이(1<=N<=50)
 K: 배추가 심어져 있는 위치의 개수(1<=K<=2500)
 map: 배추 밭을 배열로 표시한 것 (최대 50개이므로 51개로 입력)
 visit: 배추 밭의 특정 부분을 확인했는지 표시하기 위한 배열(map과 동일)
 result: 결과값을 한번에 보여주기 위한 벡터(가독성을 위한 변수이므로 굳이 필요하진 않음)
 */
int M, N, K;
bool map[51][51];
bool visit[51][51];
vector <int> result;

/*
 void DFS()
 상하좌우를 모두 확인하기 위한 함수
 DFS 방식을 이용하여 구현하였음
 */
void DFS(int y, int x) {
    visit[y][x] = true; // 현재 위치를 중복 확인하지 않기 위해서 visit 배열에서 true로 변경
    // 상
    if((y > 0) && map[y - 1][x] && !visit[y - 1][x])        DFS(y - 1, x);
    // 하
    if((y < N - 1) && map[y + 1][x] && !visit[y + 1][x])    DFS(y + 1, x);
    // 좌
    if((x > 0) && map[y][x - 1] && !visit[y][x - 1])        DFS(y, x - 1);
    // 우
    if((x < M - 1) && map[y][x + 1] && !visit[y][x + 1])    DFS(y, x + 1);
}

int main(void)
{
    /*
     testcase: 테스트 횟수
     x: x좌표
     y: y좌표
     cnt: 배추흰지렁이의 마리 수
     */
    int testcase, x, y, cnt;
    
    cin>>testcase;
    for(int i=0; i<testcase; i++) {
        cin>>M>>N>>K;
        cnt = 0;    // 배추흰지렁이 마리수를 0으로 초기화
        for(int j=0; j<K; j++) {
            cin>>x>>y;
            map[y][x] = true;  // map에서 입력받은 좌표를 true로 표시 => 지렁이가 존재하는 부분
        }
        for(int k=0; k<N; k++) {
            for(int l=0; l<M; l++) {
                if(!visit[k][l] && map[k][l]) {
                    // map의 맨 왼쪽 상단(0,0)부터 배추흰지렁이가 있으면서 동시에 방문하지 않은 곳이 있으면
                    // DFS 함수를 이용하여 확인 시작
                    DFS(k, l);
                    // 현재 배추흰지렁이로 더이상 영향을 줄 수 없으면 마리수를 늘임
                    cnt++;
                }
            }
        }
        cout<<cnt<<endl;
        // 테스트케이스가 여러번 있을 수 있으므로 초기화시켜줌
        // 테스트케이스마다 동적으로 할당할 수도 있다. 하지만 본 풀이에서는 마지막에 초기화시켜주기로 함
        for(int k=0; k<51; k++) {
            for(int l=0; l<51; l++) {
                map[k][l] = visit[k][l] = 0;
            }
        }
    }
    return 0;
}

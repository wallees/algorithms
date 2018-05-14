/* 백준 2178, 미로 탐색 : https://www.acmicpc.net/problem/2178 */

#include <iostream>
using namespace std;

/*
 미로 탐색 문제를 BFS(Breadth First Search) 알고리즘으로 풀었습니다.
 이 문제는 DFS 방식으로 풀게 되면 시간 초과가 발생하게 됩니다.
 그러므로 BFS(Breadth First Search) 알고리즘을 사용해야 합니다.
 MAX : 문제에서 제시한 최대치 100 입니다.
 map : 문제에서 제시한 미로를 나타낸 배열입니다.
 M_arr : x좌표를 삽입하는 큐입니다.
 N_arr : y좌표를 삽입하는 큐입니다.
 move_arr : 현재까지 이동한 거리를 삽입하는 큐입니다.
 M : 가로(x)의 크기입니다.
 N : 세로(y)의 크기입니다.
 queue_index : BFS는 큐(Queue)를 활용하는데, 각 큐의 인덱스를 표현할 때 사용됩니다.
 */
#define MAX 100
int map[MAX][MAX];
int M_arr[MAX*MAX], N_arr[MAX*MAX], move_arr[MAX*MAX];
int M, N, queue_index;

/*
 void enqueue()
 각 이동위치(좌표)를 큐로 삽입하는 함수입니다.
 BFS는 특정 위치를 기준으로 주변의 좌표를 큐로 삽입해서 결과값을 먼저 계산하는 방식이므로
 이동할때마다 이동한 곳의 좌표를 큐로 넣어주는 작업이 필요합니다.
 */
void enqueue(int m, int n, int move) {
    M_arr[queue_index] = m;
    N_arr[queue_index] = n;
    move_arr[queue_index] = move;
    
    // 해당 위치를 중복확인하지 않기 위한 처리가 필요합니다.
    // 여기서 중요한점은 이 과정을 '큐잉할 때' 해야하는데요,
    // 만약 BFS를 진행하는 과정에서 하게되면, 또다른 큐잉이 먼저 진행되는 경우가 발생할 수 있기 때문입니다.
    // 확실하게 큐잉까지 된 다음에 처리하는 것이 필요합니다.
    map[n][m] = 0;
    queue_index++;
}

/*
 void BFS()
 주어진 미로를 BFS 방식을 이용하여 해결해나갑니다.
 */
void BFS(int x, int y) {
    int index = 0;
    // 시작점을 enqueue 합니다.
    // [0,0]이 되겠죠?
    enqueue(x, y, 1);
    
    // 큐에 원소가 하나도 없을 때 까지 상하좌우를 동시에 확인하고 큐를 넣어줍니다.
    // 큐는 한번에 넣어지더라도 실제 동작하는건 큐의 순서대로 동작하게 됩니다.
    // BFS가 DFS보다 이런 미로탐색의 경우 더 빠른 성능을 보여줍니다.
    // 이유는 다음에 제가 더 공부해서 포스팅을 할게요.
    while((index < queue_index) && ((M_arr[index] != M - 1) || (N_arr[index] != N - 1))) {
        // DFS에서는 여기서 방문 여부를 체크해줘야했죠?
        // 하지만 BFS는 여기서하면 안됩니다. 큐에 들어가는 순간이 방문했다는 기준이 되어야 합니다.
        // map[y_arr[index]][x_arr[index]] = 0;
        
        // 상
        if((N_arr[index] > 0) && map[N_arr[index] - 1][M_arr[index]]) {
            enqueue(M_arr[index], N_arr[index] - 1, move_arr[index] + 1);
        }
        // 하
        if((N_arr[index] < N - 1) && map[N_arr[index] + 1][M_arr[index]]) {
            enqueue(M_arr[index], N_arr[index] + 1, move_arr[index] + 1);
        }
        // 좌
        if((M_arr[index] > 0) && map[N_arr[index]][M_arr[index] - 1]) {
            enqueue(M_arr[index] - 1, N_arr[index], move_arr[index] + 1);
        }
        // 우
        if((M_arr[index] < M - 1) && map[N_arr[index]][M_arr[index] + 1]) {
            enqueue(M_arr[index] + 1, N_arr[index], move_arr[index] + 1);
        }
        // 다음 큐를 실행해야 하기 때문에 index를 하나 증가해줍니다.
        index++;
    }
    
    // 큐를 모두 확인했다면, 최종 거리를 출력해줍니다.
    // 여기서 최종 거리란 최단거리로 목표지점([N-1,M-1])까지 이동한 횟수가 됩니다.
    if(index < queue_index) cout<<move_arr[index]<<"\n";
}

int main(void) {
    string input;
    cin>>N>>M;
    for(int n=0; n<N; n++) {
        cin>>input;
        for(int m=0; m<M; m++) {
            map[n][m] = input.at(m) - 48;
        }
    }
    // 어차피 move_arr이라는 큐에서 거리를 계산하기 때문에
    // BFS 함수는 시작점 위치만 받아주면 됩니다.
    BFS(0, 0);
    return 0;
}


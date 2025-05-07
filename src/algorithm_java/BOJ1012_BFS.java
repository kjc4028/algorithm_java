package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5

5
1


입력
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 두 배추의 위치가 같은 경우는 없다.

출력
각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.
 */
public class BOJ1012_BFS {

    static int[][] arr;
    static int[][] v_arr;
    static int rsCnt;

    static int[] mX = {0,0,1,-1};
    static int[] mY = {1,-1,0,0};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        

        for (int tc = 0; tc < T; tc++) {

            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken()); //밭 가로길이
            int N = Integer.parseInt(st.nextToken()); //밭 세로길이
            int K = Integer.parseInt(st.nextToken()); //위치 개수
    
            arr = new int[N][M];
            v_arr = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }    
            System.out.println("======");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(v_arr[i][j] != 1 && arr[i][j] == 1){
                        bfs(j, i, M, N);
                        rsCnt +=1;
                    }
                }
            }

            System.out.println(rsCnt);
            
             //초기화
            rsCnt = 0;
        }
    }    

    /**
     * @param x
     * @param y
     * @param M
     * @param N
     */
    static void bfs(int x, int y, int M, int N){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y,x});
        
        while (!q.isEmpty()) {
            int qy = q.peek()[0];
            int qx = q.peek()[1];
            
            v_arr[qy][qx] = 1;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int dx = qx + mX[i];
                int dy = qy + mY[i];
                
                if(dx >= 0 && dx < M && dy >= 0 && dy < N){
                    if(v_arr[dy][dx] != 1 && arr[dy][dx] == 1){
                        q.add(new int[]{dy, dx});
                        v_arr[dy][dx] = 1;
                    }
                    
                }
    
            }
        }




    }
}

package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * 
입력
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
출력
3
7
8
9
 */
public class BOJ2667A{

    
    static int[][] v_arr; // 방문여부
    static int[][] arr; // 단지정보
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동 좌표
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int currGrpNum = 0;
    static ArrayList<Integer> grpList = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        v_arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String curArrLine = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(curArrLine.charAt(j)));
            }
        }
        // System.out.println("===========");
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && v_arr[i][j] != 1){
                    currGrpNum = 0;
                    dfs(i,j);
                    grpList.add(currGrpNum);
                }

            }
        }
        grpList.sort(Comparator.naturalOrder());
        System.out.println(grpList.size());
        
        for (int n : grpList) {
            System.out.println(n);
        }

    }

    /**
     * @param x
     * @param y
     */
    private static void dfs(int x, int y) {

        v_arr[x][y] = 1; // 방문처리
        currGrpNum +=1;

        for (int i = 0; i < 4; i++) {
            int rx = x+dx[i];
            int ry = y+dy[i];

            if (rx>= 0 && rx< N && ry >= 0 && ry < N) {
                if(arr[rx][ry] == 1 && v_arr[rx][ry] != 1){
                    dfs(rx, ry);
                }
            }
        }    
    }
}


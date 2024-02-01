package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * N-QUEEN
 */
public class BOJ9663 {
    static int N;
    static int[] colArr;
    static int resultCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colArr = new int[N];

        putQueen(0);

        System.out.println(resultCnt);
    
    }

    //퀸 겹침 여부 검증
    //col 같은 값이 존재하거나 col차이와 row차이가 같은 경우 겹침으로 판단
    public static boolean isOverlapChkeck(int row, int col){
        for (int i = 0; i < row; i++) {
            if(colArr[i] == col || Math.abs(colArr[i] - col) == Math.abs(i - row)){
                return true;
            }
        }
        return false;
    }

    //퀸 배치
    public static void putQueen(int row){
        if(row == N){
            resultCnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            colArr[row] = i;
            if(!isOverlapChkeck(row, i)){
                putQueen(row+1);
            }
        }
    }


}

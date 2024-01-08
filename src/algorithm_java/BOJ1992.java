package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BOJ1992
 * 쿼드트리
 * 분할정복, 재귀
 * 
 * 
 * 입력
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011

출력
((110(0101))(0010)1(0001))
 */
public class BOJ1992 {

    public static int[][] imgArr;
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        imgArr = new int[N][N];
        for(int i = 0; i < N; i++){
            String br_str = br.readLine();
            
            for(int j = 0; j < N; j++){
                imgArr[i][j] = Integer.parseInt(br_str.substring(j, j+1));
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb.toString());

    }

    //쿼드 검증 요청
    public static void quadTree(int x, int y, int size){

        if(isCompressChk(x, y, size)){
            sb.append(imgArr[x][y]);
            return;
        }

        sb.append("(");
        int reSize = size/2;

        quadTree(x,y,reSize); //왼쪽위
        quadTree(x,y+reSize,reSize); //오른쪽위
        quadTree(x+reSize,y,reSize); //왼쪽아래
        quadTree(x+reSize,y+reSize,reSize); //오른쪽아래

        sb.append(")");
    }

    //해당노드에 다른값의 이미지가 포함되었는지 여부 체크
    public static boolean isCompressChk(int x, int y, int size){
        int validValue = imgArr[x][y];

        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if(imgArr[i][j] != validValue){
                    return false;
                }
            }
        }

        return true;
    }
}
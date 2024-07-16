package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
.F.F...F
F...F.F.
...F.F.F
F.F...F.
.F...F..
F...F.F.
.F.F.F.F
..FF..F.
 */
/*
구현
 배열에 저장하고 나중에 비교계산하지 않고
 값 입력받으면서 바로 카운트하기
 */
public class BOJ1100 {

    static final int N = 8;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int resultCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String currBaseStr = st.nextToken();
            for (int j = 0; j < N; j++) {
                char cuurChar = currBaseStr.charAt(j);
                if(i%2==0){ //홀수행 0부터 시작이기때문
                    if(j%2==0){ //홀수칸
                        if('F'==cuurChar){
                            resultCnt++;
                        }
                    }
                } else { //짝수행수행
                    if(j%2!=0){ //홀수칸
                        if('F'==cuurChar){
                            resultCnt++;
                        }
                    }
                }
            }
        }

        System.out.println(resultCnt);
        

    }
}

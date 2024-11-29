package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ15923
 * 구현
 */
public class BOJ15923 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");
        //첫번쨰 입력좌표
        int firstX = Integer.parseInt(st.nextToken());
        int firstY = Integer.parseInt(st.nextToken());
        
        //이전좌표
        int px = firstX;
        int py = firstY;
        
        int allLen = 0;    
        
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            allLen += Math.abs(x-px) + Math.abs(y-py);
            
            //이전좌표 갱신
            px = x;
            py = y;
                        
        }
        
        //마지막좌표에서 첫번째 좌표 연결
        allLen += Math.abs(firstX-px) + Math.abs(firstY-py);
        
        System.out.println(allLen);
        
    }
    
}
package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문자 하나하나를 출력하면 시간 초과 발생
 * StringBuilder를 활용하여 문자 적재 후 한번에 출력하여 시간초과 해결
 * StringBuilder와 StringBuffer 중 선택 주의
 * Stack을 활용하여 구현할수도 있음
 */

public class Z9093 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                String curStr = st.nextToken();
                for (int j = curStr.length() -1; j >= 0 ; j--) {
                    sb.append(curStr.charAt(j));
                }
                if(st.hasMoreTokens()){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
            sb = new StringBuilder();
        }

    }
}

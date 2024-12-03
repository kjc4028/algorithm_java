package algorithm_java;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * N을 N번 그리는데 M 자리까지만
 */
public class BOJ11944 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        
        String str = st.nextToken();
        
        int N = Integer.parseInt(str);
        
        int M = Integer.parseInt(st.nextToken());
        
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < N; i++) {
            sb.append(str);
            if(sb.length() >= M){
                break;
            }
        }
        String rsStr = "";
        if(sb.length() > M){
            rsStr = sb.subSequence(0, M).toString();
        } else {
            rsStr = sb.toString();
        }
        
        System.out.println(rsStr);
        
        
    }
}
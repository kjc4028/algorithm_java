package algorithm_java;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11944 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        
        String str = st.nextToken();
        
        int N = Integer.parseInt(str);
        
        int M = Integer.parseInt(st.nextToken());
        
        
        int nLength = str.length();
        
        int cnt = M/nLength;
        
        int mod = M%nLength;
        
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < cnt; i++) {
            sb.append(str);
        }
        
        sb.append(str.substring(0, mod));
        
        System.out.println(sb.toString());
        
        
    }
}

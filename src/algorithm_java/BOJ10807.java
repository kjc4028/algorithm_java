package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * map getOrDefault
 * 연산
 */
public class BOJ10807 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<String, Integer> map = new HashMap<String, Integer>();
        while(st.hasMoreTokens()){
            String currNum = st.nextToken();
            map.put(currNum,map.getOrDefault(currNum, 0)+1);
        }
        
        String v = br.readLine();
        
        //System.out.println(map.toString());
        
        int rs = 0;
        
        if(map.get(v) == null){
            rs = 0;
        } else {
            rs = map.get(v);
        }
        
        System.out.println(rs);
        
    }
}

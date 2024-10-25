
package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ19572
 */
public class BOJ19572 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int d3 = Integer.parseInt(st.nextToken());
        
        // int d1 = a+b;
        // int d2 = a+c;
        // int d3 = b+c;
        
        double rsA = (d1+d2-d3)/2.0;
        double rsB = (d1-d2+d3)/2.0;
        double rsC = (-d1+d2+d3)/2.0;
        
        // float rsA = ((d1+d2+d3)/2)-d3;
        // float rsB = (d1+d2+d3)/2-d2;
        // float rsC = (d1+d2+d3)/2-d1;
        
        if(rsA<=0 || rsB<=0 || rsC<=0){
            System.out.println("-1");
        } else {
            System.out.println("1");
            System.out.println(rsA+" "+rsB+" "+rsC);
        }
        
        
        
    }
}
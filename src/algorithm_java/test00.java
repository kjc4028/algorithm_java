package algorithm_java;

import java.util.ArrayList;

public class test00 {
    
    public static void main(String[] args) {
                // write your code in Java SE 11
                int N = 28;
                ArrayList<Integer> list = new ArrayList<Integer>();
                int getN = N;
                int sumNum = 0;
                while((getN/10) > 0){
                    sumNum += getN%10;
                    getN = getN/10;
                }
        
        
                int rsSum = 0;
                int getN2 = N;
                int sumNum2 = 0;
        
                while(rsSum != sumNum2){
                    sumNum2 = 0;
                    ++getN2;
                    rsSum = getN2;
                    while((getN2/10) > 0){
                        sumNum2 = getN2%10;
                        getN2 = getN2/10;
                    }
                    
                }
        
                System.out.println(rsSum);
        
    
    }
    

    
}

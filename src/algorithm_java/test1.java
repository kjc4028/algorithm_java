package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(A));
    }    
    public static int solution(int[] A) {
            // write your code in Java SE 8
            int result = 0;
            Set<Integer> aSet = new HashSet<Integer>();
            for (int i = 0; i < A.length; i++) {
                aSet.add(A[i]);
            }

            List<Integer> aList = new ArrayList<Integer>(aSet);
            Collections.sort(aList);

            for (int i = 0; i < aList.size(); i++) {
                int subNum = 0;
                if( (i+1)<aList.size()){
                    subNum = aList.get(i+1) - aList.get(i);
                }
                if(subNum != 1){
                    result = aList.get(i+1) - subNum +1;
                }
            }

            return result;
        }
    } 

package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
입력
5
3 4
1 1
1 -1
2 2
3 3

출력
1 -1
1 1
2 2
3 3
3 4 


6
3 4
1 1
1 -1
2 2
3 3
3 1

* 테스트 케이스 추가
y가 x 값보다 작은 케이스
 */

public class BOJ11650_Arr_Comparator {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] pairArr = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int ix = Integer.parseInt(st.nextToken());
            int iy = Integer.parseInt(st.nextToken());
            pairArr[i][0] = ix;
            pairArr[i][1] = iy;
        }        
        
        Comparator<int[]> comp = new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
            
        };

        Arrays.sort(pairArr, comp);

        for(int[] arr : pairArr){
            System.out.println(arr[0] + " " + arr[1]);
        }
    
    }
}

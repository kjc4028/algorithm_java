package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

public class BOJ11650_Arr_Comparator_Lamda {
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

        Arrays.sort(pairArr, (a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(a[1],b[1]);
            }else{
                return Integer.compare(a[0],b[0]);
            }
        });

        for(int[] arr : pairArr){
            System.out.println(arr[0] + " " + arr[1]);
        }
    
    }
}

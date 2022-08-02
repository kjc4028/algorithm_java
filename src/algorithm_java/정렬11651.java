package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 정렬11651 {
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //점의 개수
		int[][] arr = new int[N][2];
		
		//초기셋팅
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//중간 입력값 확인
/*		for(int i = 0; i < N; i++){
			System.out.println(Arrays.toString(arr[i]));
		}*/
        
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[0],o2[0]);
                } 
                return Integer.compare(o1[1],o2[1]);
            }
        });
		
		//결과표츌
		for(int i = 0; i < N; i++){
			System.out.println(arr[i][0] + " " + arr[i][1]); 
		}	
		
	}
	
}
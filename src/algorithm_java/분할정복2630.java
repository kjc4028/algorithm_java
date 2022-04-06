package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분할정복2630 {

	static int[][] arr = null;
	static int white_0 = 0;
	static int black_1 = 0;
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		StringTokenizer st;
		
		//초기값 셋팅
		for(int i =0; i<N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j<N; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//값 중간 체크
		/*for(int i =0; i<N; i++){
			for(int j =0; j<N; j++){
				System.out.print(arr[i][j] + " ");  
			}
			System.out.println();
		}*/
		
		cut(0,0,N);
		
		System.out.println(white_0);
		System.out.println(black_1);
		
	}
	
	public static void cut(int x, int y, int size){

		
		if(colorChk(x, y, size)){
			if(arr[x][y] == 0){
				white_0++;
			}
			
			if(arr[x][y] == 1){
				black_1++;
			}
			return;
		}
		
		int nextSize = size/2;
		
		cut(x, y, nextSize);
		cut(x, y+nextSize, nextSize);
		cut(x+nextSize, y, nextSize);
		cut(x+nextSize, y+nextSize, nextSize);
		
	}
	
	public static boolean colorChk(int x, int y, int size){
		
		for(int i = x; i < x+size; i++){
			for(int j = y; j < y+size; j++){
				if(arr[x][y] != arr[i][j]){ //첫번째 칸의 색상값을 기준으로 다른칸 색상과 비교 (색이 다른게 있으면 실패이기 떄문에 첫번째 칸으로만 비교)
					return false;
				}
			}
			
		}
		
		return true;
	}
}

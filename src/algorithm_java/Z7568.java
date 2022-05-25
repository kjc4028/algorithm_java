
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z7568 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		//인원수
		int N = Integer.parseInt(br.readLine());
		
		//인원
		int[][] arr = new int[N][N];
		
		//정보 셋팅
		for(int i =0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken()); //몸무게
			arr[i][1] = Integer.parseInt(st.nextToken()); //키
		}
		
		//중간확인
		for(int i =0; i < N; i++){
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
		
		
		
		for(int i =0; i < N; i++){
			int rank = 1;
			for(int j = 0; j < N; j++){
				if(i == j) continue;
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
					rank++;
				}
				
			}
			
			System.out.print(rank+ " ");
		}
		
		
		
	}
	
}

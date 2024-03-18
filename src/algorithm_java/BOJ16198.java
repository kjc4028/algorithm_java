package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * 재귀 / dfs
 * dfs 함수 호출 전 list 값 임시저장 및 제거 후 dfs 함수 완료 후 list 값 추가 
 */
public class BOJ16198 {

	static List<Integer> list = new ArrayList<Integer>();
	static int curVal = 0;
	static int maxVal = 0;
	
	public static  void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
        br.readLine();
        
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i : list) {
			System.out.println(i);
		}
		
		dfs(list,0);
		
		System.out.println(maxVal);
		
	}
	
	public static void dfs(List<Integer> curList, int curSumVal){
		

		if(curList.size() == 2){
			maxVal = Math.max(curSumVal, maxVal);
			return;
		}
		
		for (int i = 1; i < curList.size()-1; i++) {
				int calVal = curList.get(i-1)*curList.get(i+1);
				int tempVal = curList.get(i);
				curList.remove(i);
				dfs(curList,curSumVal+calVal);
				curList.add(i,tempVal);
		}
	}
	
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Z1427 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		String baseStr = br.readLine(); 
		
		int baseNum = Integer.parseInt(baseStr);
		
		int strLen = baseStr.length();
		
		Integer[] arr = new Integer[strLen]; //int형이 아닌 Integer형인 점 숙지
		
		for (int i = strLen-1; i >= 0 ; i--) {
			arr[i] = baseNum / (int)Math.pow(10, i); //해당 자리의 값 
			baseNum = baseNum % (int)Math.pow(10, i); //나머지값
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
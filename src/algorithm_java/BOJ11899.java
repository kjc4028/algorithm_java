package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11899 {

	public static void main(String[] args) throws Exception {

		final String OPEN_CMD = "("; 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		String inputText = st.nextToken();
		String[] inputTextArr = inputText.split("");
		
		Stack<String> leftStack = new Stack<>();
		Stack<String> rightStack = new Stack<>();
		
		for (String input : inputTextArr) {
			
			if(OPEN_CMD.equals(input)){
				leftStack.push(input);
			} else {
				if(leftStack.isEmpty()){
					rightStack.push(input);
				} else {
					leftStack.pop();
				}
			}
			
			
		}
		System.out.println(leftStack.size() + rightStack.size());
		
	}
}

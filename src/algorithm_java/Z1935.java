package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Z1935 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Double> stack = new Stack<Double>();
		int N = Integer.parseInt(br.readLine());
		char[] prop = br.readLine().toCharArray();
		Double[] arr = new Double[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		double result = 0;
		
		for (int i = 0; i < prop.length; i++) {
			double firstProp = 0;
			double secondProp = 0;
			
			if(prop[i] == '+'){
				firstProp = stack.pop();
				secondProp = stack.pop();
				result  = secondProp + firstProp;
				stack.push(result);
			} else if(prop[i] == '-'){
				firstProp = stack.pop();
				secondProp = stack.pop();
				result  = secondProp - firstProp;
				stack.push(result);
			} else if(prop[i] == '*'){
				firstProp = stack.pop();
				secondProp = stack.pop();
				result  = secondProp * firstProp;
				stack.push(result);
			} else if(prop[i] == '/'){
				firstProp = stack.pop();
				secondProp = stack.pop();
				result  = secondProp / firstProp;
				stack.push(result);
			} else {
				stack.push(arr[prop[i]-'A']);
			}
		}
		
		System.out.printf("%.2f",stack.peek());
		
	}
}


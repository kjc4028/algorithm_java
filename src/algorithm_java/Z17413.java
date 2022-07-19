package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Z17413 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int i = 0;
		Stack<Character> stack = new Stack<Character>();
		
		//in : true out : false
		boolean ioChk = false;
		
		while(str.length() > i){
			
			char curchr = str.charAt(i);
			
			if(curchr == '<'){
				whileStack(stack,sb);
				sb.append(curchr);
				ioChk = true;
			} else if(curchr == '>'){
				sb.append(curchr);
				ioChk = false;
			} else {
				if(ioChk){
					sb.append(curchr);
				} else {
					if(curchr != ' '){
						stack.add(curchr);
					} else {
						whileStack(stack,sb);
						sb.append(curchr);
					}
				}
			}
			i++;
		}
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
	
	public static void whileStack(Stack<Character> stack, StringBuilder stringBuilder){
		while(!stack.isEmpty()){
			stringBuilder.append(stack.pop());
		}
	}
}

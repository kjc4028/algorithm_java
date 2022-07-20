package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * 막대기자르기2
 * 스택
 *
 */
public class Z10799 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String setting = br.readLine();
		Stack<Character> stk = new Stack<>();
		int piece = 0; //조각수
		
		for (int i = 0; i < setting.length(); i++) {
			char chkSet = setting.charAt(i);
			
			if(chkSet == '('){
				stk.push(chkSet);
				continue;
			} else {
				stk.pop(); //레이저 완성
				
				if(setting.charAt(i-1) == '('){ //막재기 절단 시 레이저 좌측에 조각
					piece += stk.size();
				} else { //더이상 잘려지지 않을 막대기(이전 레이저 절단 후 우측의 막대기 조각)
					piece++;
				}
			}
		}
		System.out.println(piece);
	}
}

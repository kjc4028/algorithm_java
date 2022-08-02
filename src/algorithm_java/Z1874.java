package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Z1874 {
    
    public static void main(String[] args) throws Exception {
        //스택의 가장 위에 값이 해당 수열의 값보다 작은 경우 NO

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> baseStack = new Stack<>();
        Stack<Integer> targetStack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = n; i > 0; i--) {
           baseStack.push(n);
        }
        
        for (int i = 0; i < n; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            if(inputNum > baseStack.peek()){
                targetStack.push(baseStack.pop());
                list.add("+");
            } else if(inputNum < baseStack.peek()){
                System.out.println("NO");
                break;
            } else if(inputNum == baseStack.peek()){

            }
        }

    }
}

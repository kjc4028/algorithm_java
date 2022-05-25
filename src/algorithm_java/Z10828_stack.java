package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/10828
*/
public class Z10828_stack {
    
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        int N;
        String cmd;
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //입력받을 명령어 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cmd = st.nextToken();
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            } else {
                num = 0;
            }
            StackCall(cmd, num);
        }



    }

    public static void StackCall(String cmd, int num){
        if(cmd.equals("push")){
            stack.push(num);
        }
        if(cmd.equals("pop")){
            if(stack.empty()){
                System.out.println(-1);
            }else{
                System.out.println(stack.pop());
            }
        }
        if(cmd.equals("size")){
            System.out.println(stack.size());
        }
        if(cmd.equals("empty")){
            if(stack.empty()){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
        if(cmd.equals("top")){
            if(stack.empty()){
                System.out.println(-1);
            }else{
                System.out.println(stack.peek());
            }
        }

    }
}

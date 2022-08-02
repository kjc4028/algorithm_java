package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Z17298 {
    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> tmpStack = new Stack<Integer>();
        Stack<Integer> ansStack = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int i = 0;
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;    
        }

        for (int j = N-1; j >= 0; j--) {
            
            while(!tmpStack.isEmpty() && tmpStack.peek() <= arr[j]){
                tmpStack.pop();
            }

            if(tmpStack.isEmpty()){
                ansStack.push(-1);
            } else {
                ansStack.push(tmpStack.peek());
            }
            tmpStack.push(arr[j]);
        }

        StringBuilder sb = new StringBuilder();

        while(!ansStack.isEmpty()){
            sb.append(ansStack.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }
}

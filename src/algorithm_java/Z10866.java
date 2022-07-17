package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 덱 문제
 */
public class Z10866 {
    
    static Deque<Integer> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while(N > 0){
            st = new StringTokenizer(br.readLine());

            int stCnt = st.countTokens();
            if(stCnt > 1){
                dequeFunc(st.nextToken(), Integer.parseInt(st.nextToken()));
            } else {
                dequeFunc(st.nextToken());
            }
            N--;
        }

        System.out.println(sb.toString());

    }

    public static void dequeFunc(String cmd, int num){
        if(cmd.equals("push_front")){
            dq.addFirst(num);
        } else if(cmd.equals("push_back")){
            dq.addLast(num);
        }
    }

    public static void dequeFunc(String cmd){
        if(cmd.equals("pop_front")){
            if(!dq.isEmpty()){
                sb.append(dq.pollFirst());
            } else {
                sb.append(-1);
            }
        } else if(cmd.equals("pop_back")){
            if(!dq.isEmpty()){
                sb.append(dq.pollLast());
            } else {
                sb.append(-1);
            }
        } else if(cmd.equals("size")){
            sb.append(dq.size());
        } else if(cmd.equals("empty")){
            if(dq.isEmpty()){
                sb.append(1);
            } else {
                sb.append(0);
            }
        } else if(cmd.equals("front")){
            if(!dq.isEmpty()){
                sb.append(dq.peekFirst());
            } else {
                sb.append(-1);
            }
        } else if(cmd.equals("back")){
            if(!dq.isEmpty()){
                sb.append(dq.peekLast());
            } else {
                sb.append(-1);
            }
        }
        sb.append(System.getProperty("line.separator"));
    }



}

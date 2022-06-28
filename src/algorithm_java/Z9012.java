
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * if문의 순서를 활용
 * 다른 방법으로는 스택을 이용하는 방법이 있음
 */
public class Z9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <N; i++) {
            int clsNum = 0;
            String curStr = br.readLine();
            for (int j = 0; j < curStr.length(); j++) {
                char curC = curStr.charAt(j);
                if(curC == '('){
                    clsNum++;
                } else if(clsNum == 0){
                    clsNum = 9999; //NO값 출력하기위함
                    break;
                }else{
                    clsNum--;
                }
                
            }
            if(clsNum == 0){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
        }
    }
}

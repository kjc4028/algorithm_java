package algorithm_java;

/*
 * 두 정수 사이의 합
 */
public class PGR12912 {
    static public long solution(int a, int b) {

        if(a==b){
            return a;
        }
        
        if(a > b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        long answer = 0;
        
        for (int i = a; i <= b; i++) {
            answer += i;
        }
        
        
        return answer;
    }
    
    public static void main(String[] args) {
        System.out.println(solution(3, 5));
        System.out.println(solution(3, 3));
        System.out.println(solution(5, 3));
        System.out.println(solution(-5, 5));
    }
}

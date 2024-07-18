package algorithm_java;

/*
 * 가우스 공식
 * 두 정수 사이의 합 = (a + b) * (b - a + 1) / 2
 */
public class PGR12912_1 {
    static public long solution(int a, int b) {
        
        long answer = 0;

        
        if(a==b){
            return a;
        }
        
        if(a > b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        
            
        answer = (long)(b-a+1)*(a+b)/2;
        
        return answer;
    }
    
    public static void main(String[] args) {
        System.out.println(solution(3, 5));
        System.out.println(solution(3, 3));
        System.out.println(solution(5, 3));
        System.out.println(solution(-5, 5));
    }
}

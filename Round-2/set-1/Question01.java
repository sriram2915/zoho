import java.util.*;

/* Find the square root of a given non-negative number N. If N is not a perfect square, then return floor(sqrt(N)).
Note: Do not use the built-in square root function.
Input Format
The first and the only line of input contains a non-negative integer N.
Output Format  
Print the square root of the given number N. */


class Question01{
    //  public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int num = sc.nextInt();

    //     if(num > 0){
    //     int square = (int)Math.sqrt(num);

    //     System.out.println("square root is : "+ square);
    //     }
    //     else{
    //         System.out.println("Validation failed. The given number is not a non-negative number");
    //     }
    //     }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();

            if(num>0){

                int start = 1;
                int end = num/2;
                int f =0;
                // binary search
                while(start<end){
                    int mid = start + (end -start)/2;

                    if(mid*mid==num){
                        f=1;
                        System.out.println("square root: " + mid);
                        break;
                    }
                    else if(mid*mid>num) end = mid-1;
                    else start = mid+1;
                }
                if(f==0) System.out.println(end);
            }
            else {
                 System.out.println("Validation failed. The given number is not a non-negative number");
            }
        }
    }
   
}
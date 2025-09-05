import java.util.*;

/* Given a 2D character array, find all unique palindromic paths from the top-left corner to the bottom-right corner. You can only move either down or right at any point in time.
Input Format
The first line of input contains two integers R and C, denoting the number of rows and columns in the 2D array.
The next R lines contain C space-separated characters each, denoting the elements of the array.
Output Format
Print all unique palindromic paths from the top-left corner to the bottom-right corner. Each path should be printed in a new line. If no such path exists, print "No palindromic path".
*/
public class Question03 {

    static int max = Integer.MIN_VALUE;
    static List<String> lst = new ArrayList<>();
    static int c=0;
    public static void main(String[] args) {
        
        // char[][] arr = {{'a','b'},{'b','a'}};

        // char[][] arr = {{'a','e'},{'c','d'}};

        // char[][] arr = {{'a','x','a'},{'x','b','x'},{'a','x','a'}};

        char[][] arr = {{'a','a'},{'a','a'}};
        StringBuilder sb = new StringBuilder();

        task(arr,sb,0,0);

        System.out.println(lst);
    }

    static void task(char[][] arr, StringBuilder sb,int id,int idx){

        // System.out.println(sb);
        if(id == arr.length || idx == arr[0].length)
        {
            // System.out.println("hello");
            
            if(isPalindrome(sb) &&( (id == arr.length && idx == arr[0].length-1) || (id == arr.length && idx == arr[0].length-1))){
               
                   if(!lst.contains(sb.toString())) 
                   lst.add(sb.toString());
            } 
            return;
        }
        

        sb.append(arr[id][idx]);
       
        //  if(idx+1 <arr[0].length) 
        task(arr, sb, id, idx+1);
        //  if(id+1<=arr.length) 
        task(arr, sb, id+1, idx);
        sb.deleteCharAt(sb.length()-1);
    }

    static boolean isPalindrome(StringBuilder sb)
    {
        int i = 0;
        int j = sb.length()-1;

        // System.out.println(sb);
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
}

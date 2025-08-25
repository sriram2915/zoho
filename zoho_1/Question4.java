

public class Question4 {
    public static void main(String[] args) {
        String s = "aaabbbccc";

        String t = "abc";

        String sb="";

        int min = s.length();

        int left = 0;
        System.out.println(containsA(s, t));
        
        for(int right=0;right<s.length();right++){
            
            sb+=s.charAt(right);
            

            char temp='#';

            while(containsA(sb,t)){
                System.out.println(sb);
                temp = sb.charAt(left);
                left++;
                sb = sb.substring(left,right);
            }
           if(temp!='#') sb = temp+sb;
            System.out.println(sb+" "+sb.length());

        //    System.out.println(sb.contains(t));
        //  System.out.println(sb);
            if(containsA(sb,t)){
                
                if(min<=sb.length()) System.out.println(sb);
            }
        }

    }
    static boolean containsA(String sb,String t)
    {
            
            int j=0;
            for(int i=0;i<sb.length();i++){
                // System.out.println(t + t.length()+" "+j+t.charAt(i));
                if( sb.charAt(i)==t.charAt(j)){
                    j++;
                    
                    if(j==t.length()) return true; 
                }
            }

            return false;
    }

}

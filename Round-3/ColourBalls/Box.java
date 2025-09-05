
import java.util.*;

public class Box {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Box Size (row * column) : ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        // box for droping balls
        char[][] box = new char[row][col];

        HashMap<Integer,Integer> has = new HashMap<>();

        for(int i=0;i<box[0].length;i++){
            has.put(i,row-1);
        }
        for(char[] i: box){
            Arrays.fill(i,'-');
        }

        boolean loop = true;

        while(loop){

            System.out.println("Drop position(column): ");
            int drop = sc.nextInt();
            System.out.println("Ball Color :");
            String str = sc.next();
            char color = str.charAt(0); 
            
            // check color....

            
            int tempRow = has.get(drop);

            // terminate when column full
            if(tempRow <0) {
                System.out.println("column has reached maximum size. Program Terminated");
                break;
            }

            // drop a colour in box
            if(drop<box[0].length && col>=0 && tempRow>=0){

                box[tempRow][drop]= color; 
                has.put(drop,has.get(drop)-1);
            }

            for(char[] i:box){
                System.out.println(Arrays.toString(i));
            }

            System.out.println("Do you wish to continue(Y?N)? : ");
            String temp = sc.next();
            if(temp.charAt(0)=='n'|| temp.charAt(0)=='N'){
                loop = false;
            }
        }
        sc.close();

    }
}

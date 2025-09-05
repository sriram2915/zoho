
import java.util.*;
public class Box1 {

    static HashMap<Integer,Integer> has;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Box Size (row * column) : ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        // box for droping balls
        char[][] box = new char[row][col];

        has = new HashMap<>();
        for(int i=0;i<box[0].length;i++)   has.put(i,row-1);

        for(char[] i: box)   Arrays.fill(i,'-');
        
        boolean loop = true;
        while(loop){
            System.out.println("Drop position(column): ");
            int drop = sc.nextInt()-1;
            System.out.println("Ball Color :");
            String color = sc.next();

            int tempRow = has.get(drop);

            // terminate when column full
            if(tempRow <0) {
                System.out.println("column has reached maximum size. Program Terminated");
                break;
            }

            // drop a colour in box
            if(drop<box[0].length && col>=0 && tempRow>=0){
                
                int len = color.length();
                for(int i=0;i<len;i++){

                    if(box[tempRow%row][(drop+i)%col]!='-'){
                        while(tempRow>=0 && box[tempRow%row][(drop)%col]!='-'){
                            tempRow = tempRow-1;
                        }
                        if(tempRow<0){
                            System.out.println("We can't wrap all the colored  balls. program terminated");
                            loop = false;
                            break;
                        }
                    }
                    tempRow = has.get((drop+i)%col);
                    box[tempRow%row][(drop+i)%col]= color.charAt(i); 
                    
                    has.put((drop+i)%col,has.get((drop+i)%col)-1);
                }

                for(char[] i:box){
                    System.out.println(Arrays.toString(i));
                }

                isUnique(box);
                if(!loop) break;
            }

            System.out.println("Do you wish to continue(Y?N)? : ");
            String temp = sc.next();
            if(temp.charAt(0)=='n'|| temp.charAt(0)=='N'){
                loop = false;
            }
        }
        sc.close();

    }

    static void isUnique(char[][] box){
        int f =0;

        int n=box.length-1;
        for(int i=n;i>=0;i--){
            for(int j=1;j<box[0].length;j++){
                if(box[i][j]=='-') break;

                if(box[i][j]==box[i][j-1]) f++;
                else f=0;

                if(f==2)  brust(box, i, j, 1);
            }
        }

        for(int j=0;j<box[0].length;j++){
            for(int i=n-1;i>0;i--){
                if(box[i][j]=='-') break;

                if(box[i][j]==box[i+1][j]) f++;
                else f=0;

                if(f==2)  brust(box, i, j, 0);
            }
        }

    }

    static void brust(char[][] box,int i,int j,int check){

        if(check==1){
            for(int k=0;k<3;k++){
                box[i][j]='-';
                has.put(j,has.get(j)+1);
                j--;
            }
        }

        if(check == 0){
            for(int k=0;k<3;k++){
                box[i][j]='-';
                has.put(j,has.get(j)+1);
                i++;
            }
        }
        System.out.println("After brust....");
        for(char[] ss:box){
            System.out.println(Arrays.toString(ss));
        }
       
    }
}



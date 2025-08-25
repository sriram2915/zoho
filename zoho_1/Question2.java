

public class Question2 {
    public static void main(String[] args) {
        

        // runtime input 
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        // int k = sc.nextInt();

        //manual input

        // int[] arr = {1,2,3,4,5};
        // int  k= 6;

        int[] arr = {1,3,4,6,8};
        int k = 10;

        // int[] arr = {5,6,7,8};
        // int k = 5;
        KingdomOfNumaria(arr,k);

    }

    // O(n^2)
    static void KingdomOfNumaria(int[] arr, int k){
        int n= arr.length;
        int flag = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]<k){ 
                System.out.print("("+i+","+j+") ");
                flag = 1;
                }
                else{
                    break;
                }
            }
        }
        if(flag == 0) System.out.println("No valid pair");
    }

    // O(n logn)

    // static void KingdomOfNumaria(int[] arr, int k){

    //     int n = arr.length;
    //     for(int i=0;i<n-1;i++){

    //         int start = i+1;
    //         int end = 
    //     }
    // }


}

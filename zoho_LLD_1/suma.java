

class summa{
    public static void main(String[] args) {
        String a = "hello";
        int id =0;
        while(true){
            try{
                a.charAt(id++);
            }
            catch(StringIndexOutOfBoundsException e){
                System.out.println("Length of the String :"+ (id-1));
                break;
            }
        }
        // System.out.println(40>>1);
    }
}


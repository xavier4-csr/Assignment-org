public class Display {
    static String convertBin(int n){

        int[] binaryNum = new int[1000];
        int i = 0;

        if(n==0){
            return"0000";
        }

        while(n>0){
            binaryNum[i]=n%2;
            n = n/2;

            i++;
        }
        StringBuilder binary = new StringBuilder();
        for(int j=i-1; j>=0; j--){
            binary.append(binaryNum[j]);
        }while(binary.length()<4){
            binary.insert(0,"0");
            
        }
        return binary.toString();
    }

    static String convertHex(int n){
        String hex = Integer.toHexString(n).toLowerCase();
        return hex;

    }
    
    public static void main(String[]args){
        int[] number = {2,3};
        for(int n: number){
            String binary = convertBin(n);
            String hex = convertHex(n);
            System.out.println("decimal :(" + n + "),binary :("+ binary +"),hexadecimal :"+ hex);

            
        }
    }
}

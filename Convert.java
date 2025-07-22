import java.text.DecimalFormat;
import java.util.Random;

public class Convert{
    static String convertBin(double number){
        long integer = (long) number;
        double fraction = number - integer;

        int[]binaryNum = new int[1000];
        int i = 0;
        if(integer == 0){
            binaryNum[i] = 0;
            i++;
        }else{
            while(integer > 0){
                binaryNum[i] = (int) (integer % 2);
                integer /= 2;
                i++;


            }
        }
        StringBuilder binaryInteger = new StringBuilder();
        for(int j = i-1;j >= 0;j--){
            binaryInteger.append(binaryNum[j]);
        }
        while(binaryInteger.length()<4 && number<16){
            binaryInteger.insert(0, "0");
        }

        StringBuilder binaryFraction = new StringBuilder();
        int maxFractionalDigits = 10;
        if(fraction > 0){
            binaryFraction.append(".");
            while(fraction > 0&& binaryFraction.length() < maxFractionalDigits + 1){
                fraction *= 2;
                int bit = (int) fraction;
                binaryFraction.append(bit);
                fraction -= bit;
            }
        }
        return binaryInteger.toString() + binaryFraction.toString();
        }

        public static void main (String[]args){
            Random random = new Random();
            DecimalFormat df = new DecimalFormat("0.000");

            System.out.printf("%-15s %-30s %-25s%n","Decimal  Number","Binary Notation","Remarks");
            System.out.println("-".repeat(70));

            for (int i=0;i<30;i++){
                double number = random.nextDouble()*1000;
                number = Math.round(number * 1000.0)/1000.0;

                String binary = convertBin(number);

                String numberStr = String.valueOf(number);
                int decimalPlaces = numberStr.contains(".")?
                numberStr.split("\\.")[1].length():0;
                String remark = decimalPlaces == 5 ? "Exact" : "Approximate";

                String formattedNumber = df.format(number);
                System.out.printf("%-15s %-30s %-25s%n", formattedNumber,binary,remark);
            }
        }
    }

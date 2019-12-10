import java.text.DecimalFormat;
import java.util.Scanner;

    public class AnnualRandom  {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            double[] num = new double[21];
            num[0] = 0.00;
            num[1] = 0.00;
            num[2] = 50.00;
            double[] notAward = new double[21];
            notAward[0] = 0;
            notAward[1] = 0;
            notAward[2] = 1;
            long total = 2;
            for (int i = 3; i < 21; i++) {
                notAward[i] = (i - 1) * (notAward[i - 1] + notAward[i - 2]);
                total = total * i;
                num[i] = (double) notAward[i] / total * 100;
            }
            DecimalFormat df = new DecimalFormat(".00");
            while (scan.hasNextInt()) {
                int n = scan.nextInt();
                if (n < 0 || n > 20) {
                    System.out.println("error");
                } else {
                    System.out.println(df.format(num[n]) + "%");
                }

            }
            scan.close();
        }
    }


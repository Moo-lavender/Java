import java.util.Scanner;

public class BigIntSort {
    private static String[] sort(String[] strings) {
        String temp = null;
        for(int i = 0;i < strings.length;i++){
            for(int j = i;j < strings.length;j++){
                if(strings[i].length() > strings[j].length()){
                    temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }else if(strings[i].length() == strings[j].length()){
                    if(strings[i].compareToIgnoreCase(strings[j]) > 0){
                        temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    }
                }
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[number];
        for(int i = 0;i < strings.length;i++){
            strings[i] = scanner.nextLine();
        }
        strings = sort(strings);
        for(int i = 0;i < strings.length;i++){
            System.out.println(strings[i]);
        }
    }
}

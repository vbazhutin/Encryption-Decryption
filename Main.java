package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String action = in.nextLine();
        String text = in.nextLine();
        int key = in.nextInt();

        System.out.println(encryptOrDecrypt(action, text, key));
    }

    public static String encryptOrDecrypt(String action, String text, int key) {
        StringBuilder sb = new StringBuilder();
        if (action.equals("dec")) {
            key = -key;
        }
        for (char ch : text.toCharArray()) {
            sb.append((char) (ch + key));
        }
        return  sb.toString();
    }
}

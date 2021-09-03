package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

class ShiftAlgorithm extends Cipher {

    ShiftAlgorithm(String name) {
        super(name);
    }

    @Override
    public void encrypt(int key, String data, String in, String out) {

        StringBuilder sb = new StringBuilder();
        if ("".equals(data)) {
            File file = new File(in);
            try (Scanner scanner = new Scanner(file)) {
                data = scanner.nextLine();
            } catch (FileNotFoundException e) {
                System.out.println("No file found: " + file.getPath());
            }
        }

        for (int i = 0; i < data.length(); i++) {
            char ch = (char) (data.charAt(i) + key);

            if (Character.isLetter(data.charAt(i))) {
                int Shift = data.charAt(i) - (26 - key);

                if (ch > 'Z' && Character.isUpperCase(data.charAt(i))) {
                    sb.append((char) Shift);
                } else if (ch > 'z') {
                    sb.append((char) Shift);
                } else {
                    sb.append(ch);
                }
            } else {
                sb.append(data.charAt(i));
            }
        }

        if (out != null) {
            try (FileWriter writer = new FileWriter(out)) {
                writer.write(sb.toString());
            } catch (IOException e) {
                System.out.printf("An exception occurs %s", e.getMessage());
            }
        } else {
            System.out.println(sb);
        }
    }

    @Override
    public void decrypt(int key, String data, String in, String out) {
        encrypt(26 - key, data, in, out);
    }
}
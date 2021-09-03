package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

class UnicodeAlgorithm extends Cipher {

    UnicodeAlgorithm(String name) {
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

        for (char ch : data.toCharArray()) {
            sb.append((char) (ch + key));
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
        encrypt(-key, data, in, out);
    }
}

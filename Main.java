package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        String alg = "shift";
        String mode = "enc";
        int key = 0;
        String text = "";
        String in = null;
        String out = null;

        for (int i = 0; i < args.length; i += 2) {

            switch (args[i]) {
                case "-alg":
                    alg = args[i + 1];
                    break;
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    text = args[i + 1];
                    break;
                case "-in":
                    in = "./" + args[i + 1];
                    break;
                case "-out":
                    out = "./" + args[i + 1];
                    break;
            }
        }

        CipherFactory cipher = new CipherFactory();
        cipher.toCipher(alg, mode, key, text, in, out);
    }
}
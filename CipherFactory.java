package encryptdecrypt;

public class CipherFactory {
    public void toCipher(String alg, String mode, int key, String data, String in, String out) {
        switch (alg.toUpperCase()) {
            case "SHIFT":
                ShiftAlgorithm s = new ShiftAlgorithm(alg + "Algorithm");
                if ("enc".equals(mode)) {
                    s.encrypt(key, data, in, out);
                    System.out.println("\nShift Algo encrypt worked!");
                    break;
                }
                if ("dec".equals(mode)) {
                    s.decrypt(key, data, in, out);
                    System.out.println("\nSwitch Algo decrypt worked!");
                    break;
                }
            case "UNICODE":
                UnicodeAlgorithm u = new UnicodeAlgorithm(alg + "Algorithm");
                if ("enc".equals(mode)) {
                    u.encrypt(key, data, in, out);
                    System.out.println("\nUnicode Algo encrypt worked!");
                    break;
                }
                if ("dec".equals(mode)) {
                    u.decrypt(key, data, in, out);
                    System.out.println("\nUnicode Algo decrypt worked!");
                    break;
                }
            default:
                System.out.println("Something went wrong");
                break;
        }
    }
}

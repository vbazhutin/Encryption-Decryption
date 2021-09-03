package encryptdecrypt;

abstract class Cipher implements Algorithms {
    String name;

    Cipher(String name) {
        this.name = name;
    }

    @Override
    public void encrypt(int key, String data, String in, String out) {

    }

    @Override
    public void decrypt(int key, String data, String in, String out) {

    }
}

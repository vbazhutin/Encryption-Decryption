package encryptdecrypt;

interface Algorithms {

    void encrypt(int key, String data, String in, String out);

    void decrypt(int key, String data, String in, String out);
}

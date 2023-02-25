import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;

        int count = inputStream.read();
        while (count != -1) {
            System.out.print(count);
            count = inputStream.read();
        }

        inputStream.close();
    }
}
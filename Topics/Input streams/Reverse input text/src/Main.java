import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int charAsNumber = reader.read();
        while(charAsNumber != -1) {
            char character = (char) charAsNumber;
            stringBuilder.append(character);
            charAsNumber = reader.read();
        }
        reader.close();
        System.out.println(stringBuilder.reverse());

    }
}
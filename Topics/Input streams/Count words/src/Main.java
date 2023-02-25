import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String s = reader.readLine();
            int count = s.isBlank() ? 0 : s.trim().split("\\s+").length;

//        String[] words = s.split("\\s+");
//
//        for (String word:
//             words) {
//            if (!Objects.equals(word, " ") && !Objects.equals(word, "")) {
//                count++;
//            }
//
//        }
//        reader.close();

            System.out.println(count);
        }

    }

}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        StringBuilder jsonInput=new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
                while ((line = reader.readLine()) != null) {
                    jsonInput.append(line);
                }
        } catch (Exception e) {
            System.err.println(e);
        }
        String flattenedJson=JSONFlattener.builder().build().flattenJson(jsonInput.toString());
        System.out.println(flattenedJson);

    }
}

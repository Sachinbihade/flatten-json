import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
public class Main {
    public static void main(String[] args) {
        StringBuilder jsonInput=new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
                while (line!=null) {
                    jsonInput.append(line);
                    line = reader.readLine();
                }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        String flattenedJson=JSONFlattener.builder().build().flattenJson(jsonInput.toString());
        log.info("Flattened Json:[{}]", flattenedJson);

    }
}

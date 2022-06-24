import lombok.Builder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/*
 * JSONReader responsible for parsing a json string into json object.
 * */
@Builder
public class JSONReader {
    public JSONObject read(String file) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject= (JSONObject)parser.parse(file);
        return jsonObject;
    }
}

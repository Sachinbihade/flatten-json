import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
* Reads and parsed the json string
* Flattens json string in key-value format
* Finally coverts the map into json string
* */
@Builder
@Slf4j
public class JSONFlattener {
    public static final String KEY_SEPARATOR=".";
    public String flattenJson(String json) {
        JSONObject jsonObject=null;
        try{
            jsonObject=readJson(json);
        }catch (ParseException parseException){
            log.error("Invalid json:[{}]",json,parseException.getMessage());
            System.exit(1);
        }

        Map<String,String> flattenedMap=new HashMap();
        transform(jsonObject,flattenedMap,new StringBuilder());

        return writeJson(flattenedMap);
    }
    public JSONObject readJson(String file) throws ParseException {
        return JSONReader.builder().build().read(file);
    }
    public void transform(JSONObject jsonObject,Map<String,String> flattenedMap,
                                        StringBuilder keyBuilder){

        int size=jsonObject.size();
        if(size==0)
            return;
        Iterator rootItr=jsonObject.keySet().iterator();

        while(rootItr.hasNext()){
            StringBuilder localKeyBuilder=new StringBuilder(keyBuilder);
            String key=rootItr.next().toString();

            if(localKeyBuilder.length()>0)
                localKeyBuilder.append(KEY_SEPARATOR).append(key);
            else
                localKeyBuilder.append(key);

            Object value=jsonObject.get(key);
            if(value instanceof JSONObject){
                transform((JSONObject)value,flattenedMap,localKeyBuilder);

            }else{
                flattenedMap.put(localKeyBuilder.toString(),value.toString());
            }
        }
    }
    public String writeJson(Map<String,String> flattenedMap){
        return JSONObject.toJSONString(flattenedMap);
    }
}

package support.json;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import org.json.JSONObject;
import support.utils.Utils;

import java.io.File;
import java.io.IOException;

public class Json {
    private ReadContext json;
    private String jsonFilePath;
    private Utils utils = new Utils();

    public Json(String filePathOrJson) {
        if (filePathOrJson.contains("{")) {
            json = JsonPath.parse(filePathOrJson);
        } else {
            jsonFilePath = filePathOrJson;
            File jsonFile = utils.files.readFile(filePathOrJson);
            try {
                json = JsonPath.parse(jsonFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getValue(String queryDotNotation) {
        queryDotNotation = queryDotNotation.replaceAll("\\s+", "");
        if (queryDotNotation.equals("")) {
            return formatJson(json.jsonString());
        }
        return json.read("$." + queryDotNotation).toString();
    }

    public String toString() {
        return formatJson(json.jsonString());
    }

    public void setValue(String dotNotationQuery, String valueToSet) {
        String jsonUpdated =
                JsonPath.parse(json.jsonString()).set("$." + dotNotationQuery, valueToSet).jsonString();
        json = JsonPath.parse(jsonUpdated);
    }

    public void addObject(String queryDotNotation, String objectToAdd) {
        Object object = JsonPath.parse(objectToAdd).json();
        String jsonUpdated =
                JsonPath.parse(json.jsonString()).add("$." + queryDotNotation, object).jsonString();
        json = JsonPath.parse(jsonUpdated);
    }

    public void addValue(String queryDotNotation, String keyToAdd, String valueToAdd) {
        String jsonUpdated =
                JsonPath.parse(json.jsonString()).put("$." + queryDotNotation,  keyToAdd, valueToAdd).jsonString();
        json = JsonPath.parse(jsonUpdated);
    }

    public void addValue(String keyToAdd, String valueToAdd) {
        String jsonUpdated =
                JsonPath.parse(json.jsonString()).put("$",  keyToAdd, valueToAdd).jsonString();
        json = JsonPath.parse(jsonUpdated);
    }
    public Json getObject(String queryDotNotation) {
        Object object = json.read("$." + queryDotNotation);
        return new Json(JsonPath.parse(object).jsonString());
    }

    public int length(String queryDotNotation) {
        return json.read("$." + queryDotNotation + ".length()");
    }

    public void save() {
        if (jsonFilePath != null) {
            utils.files.writeFile(jsonFilePath, formatJson(json.jsonString()));
        }
    }

    private String formatJson(String json) {
        return new JSONObject(json).toString(2);
    }
}

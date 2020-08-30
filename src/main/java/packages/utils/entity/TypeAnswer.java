package packages.utils.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeAnswer implements Answer{
    private String result;

    public String toJson() {
        JSONObject answerJson = new JSONObject();
        JSONObject resultJson = new JSONObject();
        resultJson.put("result", result);
        answerJson.put("answer",resultJson);
        answerJson.put("type",AnswerType.TYPE.getName());
        return answerJson.toString();
    }

    public static Answer fromJson(String answer) {
        JSONTokener jsonTokener = new JSONTokener(answer);
        try {
            JSONObject answerJson = new JSONObject(jsonTokener);
            return new TypeAnswer(answerJson.getJSONObject("answer").getString("result"));
        }catch (JSONException e) {
            throw new IllegalArgumentException("Can not convert this document into Type Answer");
        }

    }
}

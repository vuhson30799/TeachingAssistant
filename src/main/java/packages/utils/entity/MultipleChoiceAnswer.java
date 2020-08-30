package packages.utils.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Data
@Builder
public class MultipleChoiceAnswer implements Answer {
    private String result;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;

    public String toJson() {
        JSONObject answerJson = new JSONObject();
        JSONObject resultJson = new JSONObject();
        resultJson.put("result", result);
        resultJson.put("choiceA", choiceA);
        resultJson.put("choiceB", choiceB);
        resultJson.put("choiceC", choiceC);
        resultJson.put("choiceD", choiceD);
        answerJson.put("answer",resultJson);
        answerJson.put("type", AnswerType.MULTIPLE_CHOICE.getName());
        return answerJson.toString();
    }

    public static Answer fromJson(String answer) {
        JSONTokener jsonTokener = new JSONTokener(answer);
        try {
            JSONObject answerJson = new JSONObject(jsonTokener);
            JSONObject answerDetail = answerJson.getJSONObject("answer");
            return MultipleChoiceAnswer.builder()
                    .result(answerDetail.getString("result"))
                    .choiceA(answerDetail.getString("choiceA"))
                    .choiceB(answerDetail.getString("choiceB"))
                    .choiceC(answerDetail.getString("choiceC"))
                    .choiceD(answerDetail.getString("choiceD"))
                    .build();
        } catch (JSONException e) {
            throw new IllegalArgumentException("Can not convert this document to Multiple Choice Answer.");
        }

    }
}

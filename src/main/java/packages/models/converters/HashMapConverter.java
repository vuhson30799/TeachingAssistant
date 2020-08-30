package packages.models.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import packages.utils.entity.Answer;
import packages.utils.entity.AnswerType;
import packages.utils.entity.MultipleChoiceAnswer;
import packages.utils.entity.TypeAnswer;

import javax.persistence.AttributeConverter;
import java.util.Map;
import java.util.Set;

public class HashMapConverter implements AttributeConverter<Answer, String> {

    @Override
    public String convertToDatabaseColumn(Answer answer) {
        return answer.toJson();
    }

    @Override
    public Answer convertToEntityAttribute(String answer) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, String> mappedValue = objectMapper.readValue(answer, Map.class);
            Set<String> keySet = mappedValue.keySet();
            String typeKey = keySet.stream()
                    .filter(key -> key.equals("type"))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Error while try to mapping answer from json."));
            String answerType = mappedValue.get(typeKey);
            if (AnswerType.MULTIPLE_CHOICE.getName().equals(answerType)) {
                return MultipleChoiceAnswer.fromJson(answer);
            }
            if (AnswerType.TYPE.getName().equals(answerType)) {
                return TypeAnswer.fromJson(answer);
            }
            throw new IllegalArgumentException("No such type of answer supported.");
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error while reading answer.");
        }
    }
}

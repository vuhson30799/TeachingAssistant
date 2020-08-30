package packages.DTO;

import lombok.Data;
import packages.utils.entity.Answer;

@Data
public class RecordDTO {
    private String question;
    private Answer answer;
}

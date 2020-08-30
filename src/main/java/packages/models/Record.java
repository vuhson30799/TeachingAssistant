package packages.models;

import lombok.Data;
import packages.models.converters.HashMapConverter;
import packages.utils.entity.Answer;

import javax.persistence.*;

@Entity
@Data
@Table(name = "record")
public class Record {
    @Id
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    @Convert(converter = HashMapConverter.class)
    private Answer answer;

    @ManyToOne(targetEntity = Test.class)
    @JoinColumn(name = "test_id")
    private Test test;
}

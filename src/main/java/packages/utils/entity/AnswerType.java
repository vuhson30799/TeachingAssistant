package packages.utils.entity;

import lombok.Getter;

public enum AnswerType {
    TYPE("type"),
    MULTIPLE_CHOICE("multipleChoice");

    AnswerType(String name) {
        this.name = name;
    }

    @Getter
    private final String name;
}

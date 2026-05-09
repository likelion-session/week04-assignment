package com.likelion04.practice5_validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoRequestDTO {

    @NotBlank(message = "제목은 필수입니다.")
    @Size(
            min = 1,
            max = 100,
            message = "제목은 1~100자여야 합니다."
    )
    private String title;

    @Size(
            max = 500,
            message = "설명은 최대 500자까지 가능합니다."
    )
    private String description;

    private boolean completed = false;

    public TodoRequestDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
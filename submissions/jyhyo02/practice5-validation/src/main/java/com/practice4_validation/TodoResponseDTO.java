package com.likelion04.practice5_validation;

import java.time.LocalDateTime;

public class TodoResponseDTO {

    private Long id;

    private String title;

    private String description;

    private boolean completed;

    private LocalDateTime createdAt;

    public TodoResponseDTO() {
    }

    public TodoResponseDTO(
            Long id,
            String title,
            String description,
            boolean completed,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
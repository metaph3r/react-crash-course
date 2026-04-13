package de.adesso.react_crash_course.note.application.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CategoryDto {

    private final UUID id;
    private final String name;
}

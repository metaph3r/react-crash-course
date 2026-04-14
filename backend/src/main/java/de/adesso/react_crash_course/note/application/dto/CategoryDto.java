package de.adesso.react_crash_course.note.application.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

    private final UUID id;
    private final String name;
}

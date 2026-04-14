package de.adesso.react_crash_course.note.application.dto;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteDto {

    private final UUID id;
    private final String note;
    private final List<CategoryDto> categories;
}

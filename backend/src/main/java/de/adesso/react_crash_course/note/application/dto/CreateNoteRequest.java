package de.adesso.react_crash_course.note.application.dto;

import java.util.List;

import lombok.Data;

@Data
public class CreateNoteRequest {

    private final String note;
    private final List<CategoryDto> categories;
}

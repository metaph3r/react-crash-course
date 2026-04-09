package de.adesso.react_crash_course.note.application.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class NoteDto {

    private final UUID id;
    private final String note;
}

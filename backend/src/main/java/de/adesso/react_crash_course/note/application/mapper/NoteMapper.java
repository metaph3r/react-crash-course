package de.adesso.react_crash_course.note.application.mapper;

import de.adesso.react_crash_course.note.application.dto.NoteDto;
import de.adesso.react_crash_course.note.domain.Note;

public final class NoteMapper {

    public static Note toEntity(NoteDto noteDto) {
        return new Note(noteDto.getId(), noteDto.getNote());
    }

    public static NoteDto toDto(Note note) {
        return new NoteDto(note.getId(), note.getNote());
    }
}
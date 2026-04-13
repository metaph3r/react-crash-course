package de.adesso.react_crash_course.note.application.mapper;

import java.util.List;

import de.adesso.react_crash_course.note.application.dto.NoteDto;
import de.adesso.react_crash_course.note.domain.Category;
import de.adesso.react_crash_course.note.domain.Note;

public final class NoteMapper {

    public static Note toEntity(NoteDto noteDto) {
        return new Note(noteDto.getId(), noteDto.getNote(),
                noteDto.getCategories().stream().map(CategoryMapper::toEntity).toList());
    }

    public static NoteDto toDto(Note note) {
        var categories = note.getCategories() == null ? List.<Category>of() : note.getCategories();
        return new NoteDto(note.getId(), note.getNote(),
                categories.stream().map(CategoryMapper::toDto).toList());
    }
}

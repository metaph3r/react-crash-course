package de.adesso.react_crash_course.note.application.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import de.adesso.react_crash_course.note.application.dto.NoteDto;
import de.adesso.react_crash_course.note.domain.Note;

@Component
public final class NoteMapper {

    public static Note toEntity(NoteDto noteDto) {
        return Note.builder()
                .id(noteDto.getId())
                .note(noteDto.getNote())
                .categories(noteDto == null ? List.of()
                        : noteDto.getCategories().stream().map(CategoryMapper::toEntity).toList())
                .build();
    }

    public static NoteDto toDto(Note note) {
        return NoteDto.builder()
                .id(note.getId())
                .note(note.getNote())
                .categories(note.getCategories().stream().map(CategoryMapper::toDto).toList())
                .build();
    }
}

package de.adesso.react_crash_course.note.application;

import java.util.List;

import org.springframework.stereotype.Service;

import de.adesso.react_crash_course.note.application.dto.CreateNoteRequest;
import de.adesso.react_crash_course.note.application.dto.NoteDto;
import de.adesso.react_crash_course.note.application.mapper.NoteMapper;
import de.adesso.react_crash_course.note.domain.Note;
import de.adesso.react_crash_course.note.persistence.NoteRepository;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteSchemaMigrationService noteSchemaMigrationService;

    public NoteService(NoteRepository noteRepository, NoteSchemaMigrationService noteSchemaMigrationService) {
        this.noteRepository = noteRepository;
        this.noteSchemaMigrationService = noteSchemaMigrationService;
    }

    public List<NoteDto> findAll() {
        return noteRepository.findAll().stream().map(note -> {
            if (!noteSchemaMigrationService.isMigrationRequired(note))
                return note;
            return noteSchemaMigrationService.migrate(note);
        }).map(NoteMapper::toDto).toList();
    }

    public NoteDto create(CreateNoteRequest createNoteRequest) {
        return NoteMapper.toDto(noteRepository.insert(Note.builder().note(createNoteRequest.getNote()).build()));
    }
}

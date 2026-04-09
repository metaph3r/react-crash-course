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

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteDto> findAll() {
        return noteRepository.findAll().stream().map(note -> NoteMapper.toDto(note)).toList();
    }

    public NoteDto create(CreateNoteRequest createNoteRequest) {
        return NoteMapper.toDto(noteRepository.insert(Note.create(createNoteRequest.getNote())));
    }
}

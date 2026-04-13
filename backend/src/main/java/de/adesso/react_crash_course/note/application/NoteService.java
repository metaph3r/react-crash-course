package de.adesso.react_crash_course.note.application;

import java.util.List;

import org.springframework.stereotype.Service;

import de.adesso.react_crash_course.note.application.dto.CreateNoteRequest;
import de.adesso.react_crash_course.note.application.dto.NoteDto;
import de.adesso.react_crash_course.note.application.mapper.NoteMapper;
import de.adesso.react_crash_course.note.domain.Category;
import de.adesso.react_crash_course.note.domain.Note;
import de.adesso.react_crash_course.note.persistence.CategoryRepository;
import de.adesso.react_crash_course.note.persistence.NoteRepository;

@Service
public class NoteService {

    private NoteRepository noteRepository;
    private CategoryRepository categoryRepository;

    public NoteService(NoteRepository noteRepository, CategoryRepository categoryRepository) {
        this.noteRepository = noteRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<NoteDto> findAll() {
        return noteRepository.findAll().stream().map(note -> NoteMapper.toDto(normalizeNote(note))).toList();
    }

    public NoteDto create(CreateNoteRequest createNoteRequest) {
        return NoteMapper.toDto(noteRepository.insert(Note.create(createNoteRequest.getNote())));
    }

    private Note normalizeNote(Note note) {
        if (note.getSchemaVersion() < Note.CURRENT_SCHEMA_VERSION) {
            var schemaVersion = note.getSchemaVersion();

            if (schemaVersion == 0) {
                var defaultCategory = categoryRepository.findByName(Category.DEFAULT_CATEGORY_STRING).stream()
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("Default category not found"));
                note = new Note(note.getId(), note.getNote(), List.of(defaultCategory));
                note.setSchemaVersion(1);
            }

            return noteRepository.save(note);
        }
        return note;
    }
}

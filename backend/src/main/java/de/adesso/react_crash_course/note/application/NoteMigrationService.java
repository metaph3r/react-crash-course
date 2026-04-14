package de.adesso.react_crash_course.note.application;

import java.util.List;

import org.springframework.stereotype.Service;

import de.adesso.react_crash_course.note.domain.Category;
import de.adesso.react_crash_course.note.domain.Note;
import de.adesso.react_crash_course.note.persistence.CategoryRepository;
import de.adesso.react_crash_course.note.persistence.NoteRepository;
import de.adesso.react_crash_course.shared.kernel.EntityMigrationService;

@Service
public class NoteMigrationService implements EntityMigrationService<Note> {

    private NoteRepository noteRepository;
    private CategoryRepository categoryRepository;

    public NoteMigrationService(NoteRepository noteRepository, CategoryRepository categoryRepository) {
        this.noteRepository = noteRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isMigrationRequired(Note note) {
        return note.getSchemaVersion() < Note.CURRENT_SCHEMA_VERSION;
    }

    @Override
    public Note migrate(Note note) {
        var schemaVersion = note.getSchemaVersion();

        if (schemaVersion == 0) {
            var defaultCategory = categoryRepository.findByName(Category.DEFAULT_CATEGORY_STRING).stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Default category not found"));
            note = new Note(note.getId(), 1, note.getNote(), List.of(defaultCategory));
        }

        return noteRepository.save(note);
    }
}

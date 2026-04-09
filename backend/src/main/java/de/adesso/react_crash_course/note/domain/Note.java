package de.adesso.react_crash_course.note.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "notes")
public class Note {

    @Id
    private final UUID id;

    @Field
    private final String note;

    public static Note create(String note) {
        return new Note(UUID.randomUUID(), note);
    }
}

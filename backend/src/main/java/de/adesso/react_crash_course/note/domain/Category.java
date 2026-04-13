package de.adesso.react_crash_course.note.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "categories")
public class Category {

    public static final String DEFAULT_CATEGORY_STRING = "Default";

    @Id
    private final UUID id;

    private int schemaVersion = 1;
    private final String name;

    public static Category create(String name) {
        return new Category(UUID.randomUUID(), name);
    }
}

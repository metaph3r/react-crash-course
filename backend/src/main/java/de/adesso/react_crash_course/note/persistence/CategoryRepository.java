package de.adesso.react_crash_course.note.persistence;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.adesso.react_crash_course.note.domain.Category;

public interface CategoryRepository extends MongoRepository<Category, UUID> {
}

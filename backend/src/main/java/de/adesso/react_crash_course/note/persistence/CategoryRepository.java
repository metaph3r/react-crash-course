package de.adesso.react_crash_course.note.persistence;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.adesso.react_crash_course.note.domain.Category;
import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, UUID> {

    List<Category> findByName(String name);
}

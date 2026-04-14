package de.adesso.react_crash_course.note.persistence;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import de.adesso.react_crash_course.note.domain.Category;

@Component
public class CategoryDataInitializer implements ApplicationRunner {

    private final CategoryRepository categoryRepository;

    public CategoryDataInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (categoryRepository.findByName(Category.DEFAULT_CATEGORY_STRING).isEmpty()) {
            categoryRepository.insert(Category.create(Category.DEFAULT_CATEGORY_STRING));
        }
    }
}

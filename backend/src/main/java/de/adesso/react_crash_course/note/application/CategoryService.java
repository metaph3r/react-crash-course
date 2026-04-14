package de.adesso.react_crash_course.note.application;

import java.util.List;

import org.springframework.stereotype.Service;

import de.adesso.react_crash_course.note.application.dto.CategoryDto;
import de.adesso.react_crash_course.note.application.dto.CreateCategoryRequest;
import de.adesso.react_crash_course.note.application.mapper.CategoryMapper;
import de.adesso.react_crash_course.note.domain.Category;
import de.adesso.react_crash_course.note.persistence.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryMapper::toDto).toList();
    }

    public CategoryDto create(CreateCategoryRequest createCategoryRequest) {
        return CategoryMapper.toDto(categoryRepository
                .insert(Category.builder().name(createCategoryRequest.getName()).build()));
    }
}

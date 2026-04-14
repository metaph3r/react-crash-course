package de.adesso.react_crash_course.note.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.adesso.react_crash_course.note.application.CategoryService;
import de.adesso.react_crash_course.note.application.dto.CategoryDto;
import de.adesso.react_crash_course.note.application.dto.CreateCategoryRequest;

@RestController
@RequestMapping("v1/categories")
public class CategoryControllerV1 {

    private final CategoryService categoryService;

    public CategoryControllerV1(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public CategoryDto create(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return categoryService.create(createCategoryRequest);
    }
}

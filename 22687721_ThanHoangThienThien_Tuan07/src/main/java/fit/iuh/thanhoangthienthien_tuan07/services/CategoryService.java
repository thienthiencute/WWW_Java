package fit.iuh.thanhoangthienthien_tuan07.services;

import fit.iuh.thanhoangthienthien_tuan07.entities.Category;
import fit.iuh.thanhoangthienthien_tuan07.reposities.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // Lấy tất cả các danh mục
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Lấy danh mục theo ID
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // Thêm hoặc cập nhật danh mục
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Xóa danh mục
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    // Method to fetch all categories
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}

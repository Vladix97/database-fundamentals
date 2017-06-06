package app.serviceImpls;

import app.daos.CategoryRepository;
import app.entities.Category;
import app.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.saveAndFlush(category);
    }

    @Override
    public List<Category> findByNameIn(String... categories) {
        return this.categoryRepository.findByNameIn(categories);
    }

    @Override
    public List<Object[]> findTotalProfitByCategory() {
        return this.categoryRepository.findTotalProfitByCategory();
    }
}

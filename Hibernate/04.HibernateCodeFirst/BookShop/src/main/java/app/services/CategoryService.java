package app.services;

import app.entities.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);

    List<Category> findByNameIn(String... categories);

    List<Object[]> findTotalProfitByCategory();
}

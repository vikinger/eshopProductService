package de.eshop.productservice;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.eshop.productservice.Category;
import de.eshop.productservice.CategoryDAO;
import de.eshop.productservice.CategoryManager;

@Repository
public class CategoryManagerImpl implements CategoryManager{
	private CategoryDAO helper;
	
	public CategoryManagerImpl() {
		helper = new CategoryDAO();
	}

	@Override
	public List<CategorySlim> getCategories() {
		List<Category> categoryList = helper.getObjectList();
		List<CategorySlim> categorySlimList = new ArrayList<CategorySlim>();
		for(Category category : categoryList)
		{
			CategorySlim categorySlim = new CategorySlim(category.getId(), category.getName());
			categorySlimList.add(categorySlim);
		}
		return categorySlimList;
	}

	@Override
	public CategorySlim getCategorySlim(int id) {
		Category category = helper.getObjectById(id);
		CategorySlim categorySlim = new CategorySlim(category.getId(), category.getName());
		return categorySlim;
	}
	
	@Override
	public Category getCategory(int id) {
		return helper.getObjectById(id);
	}

	@Override
	public CategorySlim getCategoryByName(String name) {
		Category category = helper.getObjectByName(name);
		CategorySlim categorySlim = new CategorySlim(category.getId(), category.getName());
		return categorySlim;
	}

	@Override
	public void addCategory(String name) {
		Category cat = new Category(name);
		helper.saveObject(cat);

	}

	@Override
	public void delCategory(CategorySlim cat) {
	
// 		Products are also deleted because of relation in Category.java 
		helper.deleteById(cat.getId());
	}

	@Override
	public void delCategoryById(int id) {
		
		helper.deleteById(id);
	}
}

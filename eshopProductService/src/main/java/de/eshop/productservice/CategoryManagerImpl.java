package de.eshop.productservice;


import java.util.List;

import de.eshop.productservice.Category;
import de.eshop.productservice.CategoryDAO;
import de.eshop.productservice.CategoryManager;

public class CategoryManagerImpl implements CategoryManager{
	private CategoryDAO helper;
	
	public CategoryManagerImpl() {
		helper = new CategoryDAO();
	}

	@Override
	public List<Category> getCategories() {
		return helper.getObjectList();
	}

	@Override
	public Category getCategory(int id) {
		return helper.getObjectById(id);
	}

	@Override
	public Category getCategoryByName(String name) {
		return helper.getObjectByName(name);
	}

	@Override
	public void addCategory(String name) {
		Category cat = new Category(name);
		helper.saveObject(cat);

	}

	@Override
	public void delCategory(Category cat) {
	
// 		Products are also deleted because of relation in Category.java 
		helper.deleteById(cat.getId());
	}

	@Override
	public void delCategoryById(int id) {
		
		helper.deleteById(id);
	}
}

package de.eshop.productservice;

import java.util.List;

import de.eshop.productservice.Category;

public interface CategoryManager {

	public List<CategorySlim> getCategories();
	
	public Category getCategory(int id);
	
	public CategorySlim getCategoryByName(String name);
	
	public void addCategory(String name);
	
	public void delCategory(CategorySlim cat);
	
	public void delCategoryById(int id);

	public CategorySlim getCategorySlim(int id);

	
}

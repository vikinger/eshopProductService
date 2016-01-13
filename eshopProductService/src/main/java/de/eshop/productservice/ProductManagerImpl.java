package de.eshop.productservice;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.eshop.productservice.Category;
import de.eshop.productservice.CategoryManager;
import de.eshop.productservice.Product;
import de.eshop.productservice.ProductDAO;
import de.eshop.productservice.ProductManager;

@Repository
public class ProductManagerImpl implements ProductManager {
	private ProductDAO helper;
	
	public ProductManagerImpl() {
		helper = new ProductDAO();
	}

	@Override
	public List<Product> getProducts() {
		return helper.getObjectList();
	}
	
	@Override
	public List<Product> getProductsForSearchValues(String searchDescription,
			Double searchMinPrice, Double searchMaxPrice) {	
		return new ProductDAO().getProductListByCriteria(searchDescription, searchMinPrice, searchMaxPrice);
	}

	@Override
	public Product getProductById(int id) {
		return helper.getObjectById(id);
	}

	@Override
	public Product getProductByName(String name) {
		return helper.getObjectByName(name);
	}
	
	@Override
	public int addProduct(ProductSlim productSlim) {
		int productId = -1;
		
		CategoryManager categoryManager = new CategoryManagerImpl();
		Category category = categoryManager.getCategory(productSlim.getCategory());
		
		if(category != null){
			Product newProduct;
			if(productSlim.getDetails() == null){
				newProduct = new Product(productSlim.getName(), productSlim.getPrice(), category);	
			} else{
				newProduct = new Product(productSlim.getName(), productSlim.getPrice(), category, productSlim.getDetails());
			}
			
			helper.saveObject(newProduct);
			productId = newProduct.getId();
		}
			 
		return productId;
	}
	

	@Override
	public void deleteProductById(int id) {
		helper.deleteById(id);
	}

	@Override
	public boolean deleteProductsByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

}

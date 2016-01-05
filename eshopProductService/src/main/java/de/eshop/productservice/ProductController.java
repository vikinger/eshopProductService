package de.eshop.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductManager repo;
	
	@Autowired
	private CategoryManager cm;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Product>> getProducts(){
		Iterable<Product> allProducts = repo.getProducts();
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/search", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Product>> getProductsForSearchValues(@RequestParam("value") String searchValue, @RequestParam("min") Double searchMinPrice, @RequestParam("max") Double searchMaxPrice){
		Iterable<Product> products = repo.getProductsForSearchValues(searchValue, searchMinPrice, searchMaxPrice);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
		Product product = repo.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProductById(@PathVariable Integer productId) {
		repo.deleteProductById(productId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public ResponseEntity<?> getCategoryById(@PathVariable Integer categoryId) {
		Category category = cm.getCategory(categoryId);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProductsByCategoryId(@PathVariable Integer categoryId) {
		repo.deleteProductsByCategoryId(categoryId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductByName(@RequestParam("name") String productName){
		Product product = repo.getProductByName(productName);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<?> addProduct(@RequestBody ProductSlim productSlim) {
		repo.addProduct(productSlim);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
}
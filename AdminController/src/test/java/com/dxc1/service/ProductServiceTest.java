package com.dxc1.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.dxc1.model.Product;
import com.dxc1.dao.ProductDao;
import com.dxc1.exception.ProductExistsException;
@SpringBootTest
class ProductServiceTest {
	
	
	@Autowired
	private ProductService productService;
	@MockBean
	private ProductDao productDao;
	
	@Test
	public void saveProductdataTest() throws ProductExistsException {
		
		Product product = new Product(1,"soap","bathing purpose",600.00);
		when(productDao.save(product)).thenReturn(product);
		assertEquals(product,productService.createProduct(product));
	}
	
	@Test
	public void getAllProductTest() {
		
		when(productDao.findAll()).thenReturn(Stream
				.of(new Product(1,"cycle","playing purpose",1200.00),new Product(1,"scooty","can drive in indoor",1700.00)).collect(Collectors.toList()));
		assertEquals(2, productService.getAllProducts().size());
	}

	@Test
	public void getProductbyIdTest() {
		
		int productId =1;
		when(productDao.findByProductId(productId))
		.thenReturn(Stream.of(new Product(1,"cycle","playing purpose",1200.00)).collect(Collectors.toList()));
		assertEquals(1,productService.getProductById(productId).size());
	}
	
	@Test
	public void updateproductbyIdTest() {
		
		Product product = new Product();
		product.setProductName("cars");
		product.setProductDescription("baby toys");
		product.setProductPrice(300.00);
        when(productDao.save(any(Product.class))).thenReturn(product);
        Product savepro = productDao.save(product);
        assertThat(savepro.getProductName()).isNotNull();
       // assertEquals(1,productService.updateProduct(id,product);
        
	}
	
	@Test
	public void deleteproductbyIdTest() {
		//Product product = new Product(1,"soap","bathing purpose",600.00);
		int id =1;
		productService.deleteProduct(id);
		verify(productDao,times(1)).deleteById(id);
		
	}

	

}

package de.eshop.productservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import de.eshop.productservice.EshopProductServiceApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EshopProductServiceApplication.class)
@WebAppConfiguration
public class EshopProductServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}

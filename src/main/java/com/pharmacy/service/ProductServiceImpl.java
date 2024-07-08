package com.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.entity.Product;
import com.pharmacy.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public boolean saveProduct(Product product) {
		Product addProduct = productRepository.save(product);
		return addProduct.getProductId() != null;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public boolean deleteProductById(Integer productId) {
		productRepository.deleteById(productId);
		return true;
	}

}
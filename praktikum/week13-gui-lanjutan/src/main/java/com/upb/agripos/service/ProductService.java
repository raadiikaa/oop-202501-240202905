package com.upb.agripos.service;

import java.util.List;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product p) throws Exception {
        // Validasi sederhana bisa ditambahkan di sini
        if (p.getPrice() < 0) throw new Exception("Harga tidak boleh negatif");
        productDAO.insert(p);
    }

    public void deleteProduct(String code) throws Exception {
        productDAO.delete(code);
    }

    public List<Product> getAllProducts() throws Exception {
        return productDAO.findAll();
    }
}

package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class ProductController {
    private final ProductService service;
    private final ProductTableView view;

    public ProductController(ProductService service, ProductTableView view) {
        this.service = service;
        this.view = view;
        initController();
        loadData();
    }

    private void initController() {
        // Event Handler: Tambah Produk (Lambda)
        view.getBtnAdd().setOnAction(e -> {
            try {
                Product p = view.getProductFromInput();
                service.addProduct(p);
                loadData();
                view.clearInput();
            } catch (NumberFormatException ex) {
                showAlert("Input Error", "Harga dan Stok harus angka.");
            } catch (Exception ex) {
                showAlert("Error", "Gagal menyimpan: " + ex.getMessage());
            }
        });

        // Event Handler: Hapus Produk (Lambda)
        view.getBtnDelete().setOnAction(e -> {
            Product selected = view.getTable().getSelectionModel().getSelectedItem();
            if (selected != null) {
                try {
                    service.deleteProduct(selected.getCode());
                    loadData();
                } catch (Exception ex) {
                    showAlert("Error", "Gagal menghapus: " + ex.getMessage());
                }
            } else {
                showAlert("Warning", "Pilih produk yang akan dihapus.");
            }
        });
    }

    private void loadData() {
        try {
            ObservableList<Product> data = FXCollections.observableArrayList(service.getAllProducts());
            view.getTable().setItems(data);
        } catch (Exception e) {
            showAlert("Error", "Gagal memuat data: " + e.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
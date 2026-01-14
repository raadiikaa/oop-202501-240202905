package com.upb.agripos.view;

import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * View untuk Agri-POS Application
 * Mengikuti pattern dari Bab 12-13 (GUI dengan JavaFX)
 */
public class PosView extends VBox {
    // Product Management Components
    private TextField txtProductCode;
    private TextField txtProductName;
    private TextField txtProductPrice;
    private TextField txtProductStock;
    private Button btnAddProduct;
    private Button btnDeleteProduct;
    private TableView<Product> productTable;

    // Cart Components
    private TextField txtQuantity;
    private Button btnAddToCart;
    private Button btnRemoveFromCart;
    private Button btnClearCart;
    private Button btnCheckout;
    private TableView<CartItem> cartTable;
    private Label lblCartCount;
    private Label lblCartTotal;

    public PosView() {
        initializeView();
    }

    /**
     * Menginisialisasi layout GUI
     */
    private void initializeView() {
        this.setPadding(new Insets(15));
        this.setSpacing(10);

        // ===== BAGIAN 1: MANAJEMEN PRODUK =====
        VBox productSection = createProductSection();

        // ===== BAGIAN 2: KERANJANG BELANJA =====
        VBox cartSection = createCartSection();

        // ===== BAGIAN 3: SUMMARY DAN CHECKOUT =====
        VBox summarySection = createSummarySection();

        // Tambahkan semua section ke view
        this.getChildren().addAll(
            new Label("=== AGRI-POS SYSTEM ==="),
            productSection,
            new Separator(),
            cartSection,
            new Separator(),
            summarySection
        );
    }

    /**
     * Membuat section untuk Manajemen Produk
     */
    private VBox createProductSection() {
        VBox section = new VBox(10);
        section.setPadding(new Insets(10));
        section.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5;");

        Label title = new Label("Manajemen Produk");
        title.setStyle("-fx-font-size: 14; -fx-font-weight: bold;");

        // Form Input Produk
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Kode:"), 0, 0);
        txtProductCode = new TextField();
        form.add(txtProductCode, 1, 0);

        form.add(new Label("Nama:"), 0, 1);
        txtProductName = new TextField();
        form.add(txtProductName, 1, 1);

        form.add(new Label("Harga:"), 0, 2);
        txtProductPrice = new TextField();
        form.add(txtProductPrice, 1, 2);

        form.add(new Label("Stok:"), 0, 3);
        txtProductStock = new TextField();
        form.add(txtProductStock, 1, 3);

        // Buttons
        HBox buttonBox = new HBox(10);
        btnAddProduct = new Button("Tambah Produk");
        btnAddProduct.setPrefWidth(150);
        btnDeleteProduct = new Button("Hapus Produk");
        btnDeleteProduct.setPrefWidth(150);
        buttonBox.getChildren().addAll(btnAddProduct, btnDeleteProduct);

        // Table Produk
        productTable = new TableView<>();
        createProductTableColumns();
        productTable.setPrefHeight(200);

        section.getChildren().addAll(title, form, buttonBox, new Label("Daftar Produk:"), productTable);
        return section;
    }

    /**
     * Setup column untuk Product Table
     */
    private void createProductTableColumns() {
        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colCode.setPrefWidth(100);

        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colName.setPrefWidth(200);

        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colPrice.setPrefWidth(100);

        TableColumn<Product, Integer> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colStock.setPrefWidth(100);

        productTable.getColumns().addAll(colCode, colName, colPrice, colStock);
    }

    /**
     * Membuat section untuk Keranjang Belanja
     */
    private VBox createCartSection() {
        VBox section = new VBox(10);
        section.setPadding(new Insets(10));
        section.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5;");

        Label title = new Label("Keranjang Belanja");
        title.setStyle("-fx-font-size: 14; -fx-font-weight: bold;");

        // Input Quantity
        HBox quantityBox = new HBox(10);
        quantityBox.getChildren().addAll(
            new Label("Jumlah:"),
            txtQuantity = new TextField(),
            btnAddToCart = new Button("Tambah ke Keranjang")
        );
        txtQuantity.setPrefWidth(100);
        btnAddToCart.setPrefWidth(150);

        // Table Keranjang
        cartTable = new TableView<>();
        createCartTableColumns();
        cartTable.setPrefHeight(200);

        // Buttons
        HBox cartButtonBox = new HBox(10);
        btnRemoveFromCart = new Button("Hapus Item");
        btnRemoveFromCart.setPrefWidth(150);
        btnClearCart = new Button("Clear Keranjang");
        btnClearCart.setPrefWidth(150);
        cartButtonBox.getChildren().addAll(btnRemoveFromCart, btnClearCart);

        section.getChildren().addAll(title, quantityBox, new Label("Isi Keranjang:"), cartTable, cartButtonBox);
        return section;
    }

    /**
     * Setup column untuk Cart Table
     */
    private void createCartTableColumns() {
        TableColumn<CartItem, String> colCode = new TableColumn<>("Kode Produk");
        colCode.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
            cellData.getValue().getProduct().getCode()
        ));
        colCode.setPrefWidth(100);

        TableColumn<CartItem, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
            cellData.getValue().getProduct().getName()
        ));
        colName.setPrefWidth(150);

        TableColumn<CartItem, Integer> colQty = new TableColumn<>("Qty");
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colQty.setPrefWidth(80);

        TableColumn<CartItem, Double> colSubtotal = new TableColumn<>("Subtotal");
        colSubtotal.setCellValueFactory(cellData -> new javafx.beans.property.SimpleDoubleProperty(
            cellData.getValue().getSubtotal()
        ).asObject());
        colSubtotal.setPrefWidth(120);

        cartTable.getColumns().addAll(colCode, colName, colQty, colSubtotal);
    }

    /**
     * Membuat section untuk Summary dan Checkout
     */
    private VBox createSummarySection() {
        VBox section = new VBox(10);
        section.setPadding(new Insets(10));
        section.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5;");

        Label title = new Label("Ringkasan & Checkout");
        title.setStyle("-fx-font-size: 14; -fx-font-weight: bold;");

        // Summary Info
        HBox summaryBox = new HBox(20);
        lblCartCount = new Label("Total Item: 0");
        lblCartCount.setStyle("-fx-font-size: 12;");
        lblCartTotal = new Label("Total: Rp. 0");
        lblCartTotal.setStyle("-fx-font-size: 12; -fx-font-weight: bold;");
        summaryBox.getChildren().addAll(lblCartCount, lblCartTotal);

        // Checkout Button
        btnCheckout = new Button("Checkout");
        btnCheckout.setPrefWidth(200);
        btnCheckout.setStyle("-fx-font-size: 12; -fx-padding: 10;");

        section.getChildren().addAll(title, summaryBox, btnCheckout);
        return section;
    }

    // ===== GETTERS =====
    public Button getBtnAddProduct() { return btnAddProduct; }
    public Button getBtnDeleteProduct() { return btnDeleteProduct; }
    public Button getBtnAddToCart() { return btnAddToCart; }
    public Button getBtnRemoveFromCart() { return btnRemoveFromCart; }
    public Button getBtnClearCart() { return btnClearCart; }
    public Button getBtnCheckout() { return btnCheckout; }
    public TableView<Product> getProductTable() { return productTable; }
    public TableView<CartItem> getCartTable() { return cartTable; }

    /**
     * Mengambil data produk dari form input
     */
    public Product getProductFromInput() throws NumberFormatException {
        return new Product(
            txtProductCode.getText(),
            txtProductName.getText(),
            Double.parseDouble(txtProductPrice.getText()),
            Integer.parseInt(txtProductStock.getText())
        );
    }

    /**
     * Mengambil quantity dari input
     */
    public int getQuantityFromInput() throws NumberFormatException {
        return Integer.parseInt(txtQuantity.getText());
    }

    /**
     * Mengosongkan product input form
     */
    public void clearProductInput() {
        txtProductCode.clear();
        txtProductName.clear();
        txtProductPrice.clear();
        txtProductStock.clear();
    }

    /**
     * Mengosongkan quantity input
     */
    public void clearQuantityInput() {
        txtQuantity.clear();
    }

    /**
     * Mengupdate summary display
     */
    public void updateCartSummary(int itemCount, double total) {
        lblCartCount.setText("Total Item: " + itemCount);
        lblCartTotal.setText(String.format("Total: Rp. %.2f", total));
    }
}
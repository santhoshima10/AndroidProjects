package com.example.android.farmfreshinventory.data;

public class Product {

    public Product(int mProductId, String mProductName, int mProductUnitPrice, int mProductQuantity) {
        this.mProductId = mProductId;
        this.mProductName = mProductName;
        this.mProductUnitPrice = mProductUnitPrice;
        this.mProductQuantity = mProductQuantity;
    }

    private  int mProductId;
    private  String mProductName;
    private  int mProductUnitPrice;
    private  int mProductQuantity;
    private  String mProductSupplierName;
    private  int mProductSupplierPhone;
    private  String mProductSupplierEmail;
    private  String mProductImageUri;


    public int getmProductId() {
        return mProductId;
    }

    public String getmProductName() {
        return mProductName;
    }

    public int getmProductUnitPrice() {
        return mProductUnitPrice;
    }

    public int getmProductQuantity() {
        return mProductQuantity;
    }
}

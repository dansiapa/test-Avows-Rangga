package com.test.gmart.dto.troli;

public class TroliDTO {
    private String titleProduct;
    private int hargaProduct;
    private String userName;
    private int qtyProduct;
    private int totalHarga;

    public String getTitleProduct() {
        return titleProduct;
    }

    public void setTitleProduct(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public int getHargaProduct() {
        return hargaProduct;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setHargaProduct(int hargaProduct) {
        this.hargaProduct = hargaProduct;
    }

    public int getQtyProduct() {
        return qtyProduct;
    }

    public void setQtyProduct(int qtyProduct) {
        this.qtyProduct = qtyProduct;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
}

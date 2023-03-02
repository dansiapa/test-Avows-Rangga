package com.test.gmart.dto.troli;

public class AddTroliDTO {
    private String titleProduct;
    private int hargaProduct;
    private int qtyProduct;

    public String getTitleProduct() {
        return titleProduct;
    }

    public void setTitleProduct(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public int getHargaProduct() {
        return hargaProduct;
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
}

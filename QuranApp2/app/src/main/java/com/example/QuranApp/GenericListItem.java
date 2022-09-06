package com.example.QuranApp;

public class GenericListItem {
    private String firstEntity;
    private String secendEntity;


    public GenericListItem(String firstEntity, String secendEntity) {
        this.firstEntity = firstEntity;
        this.secendEntity = secendEntity;
    }
    public GenericListItem() {

    }

    public String getFirstEntity() {
        return firstEntity;
    }

    public void setFirstEntity(String firstEntity) {
        this.firstEntity = firstEntity;
    }

    public String getSecendEntity() {
        return secendEntity;
    }

    public void setSecendEntity(String secendEntity) {
        this.secendEntity = secendEntity;
    }
}

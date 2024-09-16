package com.jlzdev.supermarket.domain;

public class Category {
  private int categoryId;
  private String category;
  private boolean active;

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  @Override
  public String toString() {
    return "Category{" +
        "active=" + active +
        ", categoryId=" + categoryId +
        ", category='" + category + '\'' +
        '}';
  }
}

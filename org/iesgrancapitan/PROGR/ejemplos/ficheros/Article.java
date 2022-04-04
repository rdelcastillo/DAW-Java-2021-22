package org.iesgrancapitan.PROGR.ejemplos.ficheros;

public class Article {

  private int code;
  private String description;
  private double price;
  private int units;
  
  public Article(int code, String description, double price, int units) {
    this.code = code;
    this.description = description;
    this.price = price;
    this.units = units;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public double getPrice() {
    return price;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
  
  public int getUnits() {
    return units;
  }
  
  public void setUnits(int units) {
    this.units = units;
  }

  @Override
  public String toString() {
    return "Articulo [code=" + code + ", description=" + description + ", price=" + price
        + ", units=" + units + "]";
  }

}

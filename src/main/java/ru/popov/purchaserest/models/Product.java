package ru.popov.purchaserest.models;




import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name ="PRODUCT")
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "ID")
   private Long id;
   @Column(name = "NAME")
   private String name;
   @Column(name = "PRICE")
   private double price;

   @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
   @JsonIgnore
   private Purchase purchase;


   public Product() {
   }

   public Product(String name, double price) {
      this.name = name;
      this.price = price;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public Purchase getPurchase() {
      return purchase;
   }

   public void setPurchase(Purchase purchase) {
      this.purchase = purchase;
   }

   @Override
   public String toString() {
      return "Product{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", price=" + price +
              '}';
   }
}

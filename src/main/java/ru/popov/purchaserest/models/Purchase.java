package ru.popov.purchaserest.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
;


@Entity
@Table(name="PURCHASE")
public class Purchase {
    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "COUNT")
    private int count;
    @Column(name = "DATA_PURCHASE")
    private LocalDate datePurchaseLocal= LocalDate.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    public Purchase() {
    }

    public Purchase(Long id, String name, int count, LocalDate datePurchaseLocal, Person person, Product product) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.datePurchaseLocal = datePurchaseLocal;
        this.person = person;
        this.product = product;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDate getDatePurchaseLocal() {
        return datePurchaseLocal;
    }

    public void setDatePurchaseLocal(LocalDate datePurchaseLocal) {
        this.datePurchaseLocal = datePurchaseLocal;

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return count == purchase.count && Objects.equals(id, purchase.id) && Objects.equals(name, purchase.name) && Objects.equals(datePurchaseLocal, purchase.datePurchaseLocal) && Objects.equals(person, purchase.person) && Objects.equals(product, purchase.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, count, datePurchaseLocal, person, product);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", datePurchaseLocal=" + datePurchaseLocal +
                ", person=" + person +
                ", product=" + product +
                '}';
    }
}

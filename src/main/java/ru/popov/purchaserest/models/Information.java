package ru.popov.purchaserest.models;

import javax.persistence.*;

@Entity
@Table(name = "INFORMATION")
public class Information {
    @Id
    @Column(name ="ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name ="NAME")
    private String name;
    @Column(name ="LAST_NAME")
    private String lastName;
    @Column(name ="AGE")
    private int age;
    @Column(name ="COUNT")
    private int count;
    @Column(name ="AMOUNT")
    private double amount;
    @Column(name ="PURCHASE_DATE")
    private String purchase_date;
    @Column(name ="PURCHASE")
    private String purchase;

    @OneToOne(mappedBy ="information" )
    private Purchase purchases;



    public Information() {
    }

    public Information(String name, String lastName, int age, int count, double amount, String purchase_date, String purchase, Purchase purchases) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.count = count;
        this.amount = amount;
        this.purchase_date = purchase_date;
        this.purchase = purchase;
        this.purchases = purchases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getPurchase() {
        return purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }

    public Purchase getPurchases() {
        return purchases;
    }

    public void setPurchases(Purchase purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", count=" + count +
                ", amount=" + amount +
                ", purchase_date='" + purchase_date + '\'' +
                ", purchase=" + purchase +
                '}';
    }
}

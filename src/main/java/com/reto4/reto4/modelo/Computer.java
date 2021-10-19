package com.reto4.reto4.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="computer")
public class Computer implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    
    private String description;

    @JsonIgnoreProperties("computers")
    @ManyToOne
    @JoinColumn(name = "category_id")
    
    private Category category;

    @JsonIgnoreProperties({"computer","client"})
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "computer")
   
    private List<Message>messages;


    @JsonIgnoreProperties({"computer","client"})
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "computer")
    
    private List<Reservation> reservations;

  

    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}

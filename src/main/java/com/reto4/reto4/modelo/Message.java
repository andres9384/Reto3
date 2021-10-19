package com.reto4.reto4.modelo;

import java.io.Serializable;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="message")
public class Message implements Serializable{
    @JsonIgnoreProperties({"client"})
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    // @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "message")
    
    @JsonIgnoreProperties({"messages","reservations"})
//   "message","reservation",

    @ManyToOne
    @JoinColumn(name = "computer_id")
  
    private Computer computer;
    @JsonIgnoreProperties({"messages","reservations","client"})
    @ManyToOne
    
    @JoinColumn(name = "client_id")
    
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    
}

package com.reto4.reto4.modelo.Reporte;

import com.reto4.reto4.modelo.Client;

public class ContReservations {
    private Long total;
    private Client client;
    
    public ContReservations(Long total, Client client) {
        this.total = total;
        this.client = client;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    
}

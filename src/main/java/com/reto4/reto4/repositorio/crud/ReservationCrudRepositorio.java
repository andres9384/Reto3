package com.reto4.reto4.repositorio.crud;

import java.util.Date;
import java.util.List;

import com.reto4.reto4.modelo.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepositorio extends CrudRepository<Reservation, Integer> {

    @Query("select e.client, COUNT(e.client) from Reservation as e group by e.client order by COUNT(e.client) desc")
    public List<Object[]> countTotalReservationByClient();

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date start, Date end);

    public List<Reservation> findAllByStatus(String estado);
}

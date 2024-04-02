package com.nusteam11.team11.repository;

import com.nusteam11.team11.model.Reservations;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Integer>{
    List<Reservations> findByUserId(int Userid);

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE reservations AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}

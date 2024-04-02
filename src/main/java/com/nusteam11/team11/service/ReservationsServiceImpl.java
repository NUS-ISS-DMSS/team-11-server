package com.nusteam11.team11.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nusteam11.team11.model.Reservations;
import com.nusteam11.team11.repository.ReservationsRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationsServiceImpl implements ReservationsService{

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Override
    public Reservations saveReservations(Reservations reservations) {
        return reservationsRepository.save(reservations);
    }

    @Override
    public List<Reservations> getAllReservations(Reservations reservations, int userID) {
        return reservationsRepository.findByUserId(userID);
    }

    @Override
    @Transactional
    public Reservations deleteListing(int listingId) {
        Optional<Reservations> optionalReservation = reservationsRepository.findById(listingId);

        if (optionalReservation.isPresent()) {
            Reservations reservation = optionalReservation.get();
            reservationsRepository.deleteById(listingId);
            resetAutoIncrement();
            return reservation;
        } else {
            throw new NoSuchElementException("Reservation not found with id: " + listingId);
        }
    }

    private void resetAutoIncrement() {
        reservationsRepository.resetAutoIncrement();
    }
}

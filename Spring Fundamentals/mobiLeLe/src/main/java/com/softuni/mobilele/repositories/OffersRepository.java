package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffersRepository extends JpaRepository<Offer, Long> {
}

package com.pub.repositories;

import com.pub.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

}

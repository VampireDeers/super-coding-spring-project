package com.github.supercodingspringproject.repository.sneaker;

import com.github.supercodingspringproject.repository.sneaker.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SneakerRepository extends JpaRepository<Sneaker, Integer> {
}
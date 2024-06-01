package com.ecommerce.end.repositories;

import com.ecommerce.end.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
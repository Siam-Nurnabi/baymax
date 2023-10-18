package com.example.Baymax.repository.bay;

import com.example.Baymax.model.bay.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IImageDataRepository extends JpaRepository<ImageData,Long> {
    Optional<ImageData> findByName(String name);
}

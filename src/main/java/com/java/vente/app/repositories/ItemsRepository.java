package com.java.vente.app.repositories;

import com.java.vente.app.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Long> {
}

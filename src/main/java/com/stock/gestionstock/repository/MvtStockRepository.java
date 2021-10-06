package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.MvtStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MvtStockRepository extends JpaRepository<MvtStock,Integer> {

    Optional<MvtStock> findById(Integer id);
}

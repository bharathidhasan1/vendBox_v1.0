package com.org.vendbox.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.vendbox.model.VendingMachine;

@Repository
public interface VendingMachineRepository extends JpaRepository<VendingMachine, Integer> {
    Optional<VendingMachine> findByMissionId(Integer missionId);
    List<VendingMachine> findByCurrentStockGreaterThan(Integer currentStock);
	List<VendingMachine> findByCurrentStockLessThan(Integer currentStock);

}

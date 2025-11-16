package com.org.vendbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.vendbox.dto.VendingMachineDTO;
import com.org.vendbox.model.VendingMachine;
import com.org.vendbox.repository.VendingMachineRepository;

@Service
public class VendingMachineService {

	@Autowired
	private VendingMachineRepository vendingMachineRepository;

	@Autowired
	private ModelMapper modelMapper;

	// Convert Entity to DTO
	private VendingMachineDTO convertToDTO(VendingMachine vendingMachine) {
		return modelMapper.map(vendingMachine, VendingMachineDTO.class);
	}

	// Convert DTO to Entity
	private VendingMachine convertToEntity(VendingMachineDTO vendingMachineDTO) {
		return modelMapper.map(vendingMachineDTO, VendingMachine.class);
	}

	// GET: Fetch all current stocks and return as DTO list
	public List<VendingMachineDTO> getCurrentStocks() {
		List<VendingMachine> machines = vendingMachineRepository.findAll();
		return machines.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	// GET: Fetch vending machines with low stock (currentStock < 5)
	public List<VendingMachineDTO> getLowStockAlerts() {
		List<VendingMachine> lowStockMachines = vendingMachineRepository.findByCurrentStockLessThan(5);

		return lowStockMachines.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public VendingMachineDTO getCurrentStockByMissionId(Integer missionId) {
		Optional<VendingMachine> vendingMachineOpt = vendingMachineRepository.findByMissionId(missionId);

		if (vendingMachineOpt.isPresent()) {
			return convertToDTO(vendingMachineOpt.get());
		} else {
			throw new RuntimeException("Vending Machine with missionId " + missionId + " not found");
		}
	}

	// PUT API: Automatically update soldStock for all machines
	public List<VendingMachineDTO> autoUpdateSoldStockForAllMachines() {
		List<VendingMachine> vendingMachines = vendingMachineRepository.findAll();

		for (VendingMachine machine : vendingMachines) {
			// Increase sold stock (simulating sales, here increasing by 1 per machine)
//			machine.setSoldStock(machine.getSoldStock() + 1);
//			machine.setCurrentStock(machine.getTotalStock() - machine.getSoldStock());

			// Set refilling alert if stock is low
			if (machine.getCurrentStock() < 5) {
				machine.setRefillingAlert("Critical - LOW Stocks : " + machine.getCurrentStock());
			} else {
				machine.setRefillingAlert("Available Stocks: " + machine.getCurrentStock());
			}
		}

		// Save updated machines
		vendingMachineRepository.saveAll(vendingMachines);

		return vendingMachines.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	
	// Add to your VendingMachineService

	public void handlePurchase(Integer missionId, Integer soldStock, String paymentMode) {
	    Optional<VendingMachine> vendingMachineOpt = vendingMachineRepository.findByMissionId(missionId);
	    if (!vendingMachineOpt.isPresent()) {
	        throw new RuntimeException("Vending Machine with missionId " + missionId + " not found");
	    }

	    VendingMachine vendingMachine = vendingMachineOpt.get();

	    if (vendingMachine.getCurrentStock() < soldStock) {
	        throw new RuntimeException("Not enough stock available.");
	    }

	    int newCurrentStock = vendingMachine.getCurrentStock() - soldStock;
	    int newSoldStock = vendingMachine.getSoldStock() + soldStock;

	    vendingMachine.setCurrentStock(newCurrentStock);
	    vendingMachine.setSoldStock(newSoldStock);
	    vendingMachine.setPaymentMode(paymentMode);
	    vendingMachine.setDateAndTimeSold(LocalDateTime.now());

	    if (newCurrentStock <= 5) {
	        vendingMachine.setRefillingAlert("Critical - LOW Stocks : " + newCurrentStock);
	    } else {
	        vendingMachine.setRefillingAlert("Available Stocks: " + newCurrentStock);
	    }

	    vendingMachineRepository.save(vendingMachine);
	}


	

}

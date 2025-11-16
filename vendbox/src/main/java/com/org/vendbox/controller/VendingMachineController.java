package com.org.vendbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.vendbox.dto.VendingMachineDTO;
import com.org.vendbox.service.VendingMachineService;

@RestController
@RequestMapping("/api/vending")
public class VendingMachineController {

	@Autowired
	private VendingMachineService vendingMachineService;

	// GET API - Fetch all current stocks (returns DTO)
	@GetMapping("/stocks")
	public List<VendingMachineDTO> getCurrentStocks() {
		return vendingMachineService.getCurrentStocks();
	}

	@GetMapping("/stocks/{missionId}")
	public VendingMachineDTO getCurrentStockByMissionId(@PathVariable Integer missionId) {
		return vendingMachineService.getCurrentStockByMissionId(missionId);
	}

	// GET API - Fetch all vending machines where stock is low
	@GetMapping("/low-stock-alerts")
	public List<VendingMachineDTO> getLowStockAlerts() {
		return vendingMachineService.getLowStockAlerts();
	}

	// PUT API - Automatically update soldStock for all machines
	@PutMapping("/auto-update-sold")
	public List<VendingMachineDTO> autoUpdateSoldStockForAll() {
		return vendingMachineService.autoUpdateSoldStockForAllMachines();
	}

	// Add to your VendingMachineController

	@PostMapping("/buy/{missionId}")
	public ResponseEntity<String> buyItems(@PathVariable Integer missionId, 
	                                       @RequestParam Integer soldStock,
	                                       @RequestParam String paymentMode) {
	    System.out.println("Mission ID: " + missionId);
	    System.out.println("Sold Stock: " + soldStock);
	    System.out.println("Payment Mode: " + paymentMode);

	    try {
	        vendingMachineService.handlePurchase(missionId, soldStock, paymentMode);
	        return ResponseEntity.ok("Transaction successful. Stock and sales updated.");
	    } catch (RuntimeException e) {
	        e.printStackTrace();
	        return ResponseEntity.status(400).body("Error: " + e.getMessage());
	    }
	}


}

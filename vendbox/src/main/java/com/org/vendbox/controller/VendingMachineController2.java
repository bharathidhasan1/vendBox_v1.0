//package com.org.vendbox.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.org.vendbox.model.VendingMachine;
//import com.org.vendbox.service.VendingMachineService;
//
//@RestController
//@RequestMapping("/api/vending-machine")
//public class VendingMachineController2 {
//
//	private final VendingMachineService vendingMachineService;
//
//	@Autowired
//	public VendingMachineController2(VendingMachineService vendingMachineService) {
//		this.vendingMachineService = vendingMachineService;
//	}
//	
//	// Get Current Stock, Sold Items, and Refill Alerts
//	@GetMapping("/stock/{missionId}")
//	public ResponseEntity<VendingMachine> getCurrentStock(@PathVariable Integer missionId) {
//		VendingMachine machineInfo = vendingMachineService.getCurrentStock(missionId);
//		return ResponseEntity.ok(machineInfo);
//	}
//
//
//	// Update Machine Status (ON/OFF)
//	@PutMapping("/status/{missionId}")
//	public ResponseEntity<String> updateMachineStatus(@PathVariable Integer missionId, @RequestParam String status) {
//		vendingMachineService.updateMachineStatus(missionId, status);
//		return ResponseEntity.ok("Machine status updated successfully");
//	}
//
//
//	// Update Sold Items and Refill Alerts
//	@PutMapping("/update/{missionId}")
//	public ResponseEntity<String> updateSoldItemsAndRefillAlert(@PathVariable Integer missionId,
//			@RequestBody @Valid VendingMachine vendingMachine) {
//		vendingMachineService.updateSoldItemsAndRefillAlert(missionId, vendingMachine);
//		return ResponseEntity.ok("Sold items and refill alert updated successfully");
//	}
//
//	// Log Sales Data (time, date, amount collected)
//	@PostMapping("/sales")
//	public ResponseEntity<String> logSalesData(@RequestBody @Valid VendingMachine vendingMachine) {
//		vendingMachineService.logSalesData(vendingMachine);
//		return ResponseEntity.ok("Sales data logged successfully");
//	}
//
//	// Send Machine Updates (stock, sales, status) to an external API
//	@PostMapping("/send-machine-updates/{missionId}")
//	public ResponseEntity<String> sendMachineUpdates(@PathVariable Integer missionId) {
//		vendingMachineService.sendMachineUpdates(missionId);
//		return ResponseEntity.ok("Machine updates sent successfully");
//	}
//
//	// Receive Dispense Commands from Backend after Coin Validation
//	@PostMapping("/receive-dispense-command")
//	public ResponseEntity<String> receiveDispenseCommand(@RequestBody String dispenseCommand) {
//		vendingMachineService.handleDispenseCommand(dispenseCommand);
//		return ResponseEntity.ok("Dispense command processed");
//	}
//}

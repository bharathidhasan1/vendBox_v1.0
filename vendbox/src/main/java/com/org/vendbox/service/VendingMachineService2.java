//package com.org.vendbox.service;
//
//import com.org.vendbox.model.VendingMachine;
//import com.org.vendbox.repository.VendingMachineRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class VendingMachineService2 {
//
//    private final VendingMachineRepository vendingMachineRepository;
//
//    @Autowired
//    public VendingMachineService2(VendingMachineRepository vendingMachineRepository) {
//        this.vendingMachineRepository = vendingMachineRepository;
//    }
//
//    // Get Current Stock, Sold Items, and Refill Alerts
//    public VendingMachine getCurrentStock(Integer missionId) {
//        return vendingMachineRepository.findByMissionId(missionId)
//                .orElseThrow(() -> new RuntimeException("Vending machine not found"));
//    }
//    
//    
//    // Update Machine Status (ON/OFF)
//    @Transactional
//    public void updateMachineStatus(Integer missionId, String status) {
//        VendingMachine machine = vendingMachineRepository.findByMissionId(missionId)
//                .orElseThrow(() -> new RuntimeException("Vending machine not found"));
//        machine.setMissionStatus(status);
//        vendingMachineRepository.save(machine);
//    }
//   
//
//    // Update Sold Items and Refill Alerts
//    @Transactional
//    public void updateSoldItemsAndRefillAlert(Integer missionId, VendingMachine vendingMachine) {
//        VendingMachine existingMachine = vendingMachineRepository.findByMissionId(missionId)
//                .orElseThrow(() -> new RuntimeException("Vending machine not found"));
//
//        existingMachine.setSoldStock(vendingMachine.getSoldStock());
//        existingMachine.setRefillingAlert(vendingMachine.getRefillingAlert());
//        existingMachine.setCurrentStock(vendingMachine.getCurrentStock());
//        vendingMachineRepository.save(existingMachine);
//    }
//
//    // Log Sales Data (time, date, amount collected)
//    @Transactional
//    public void logSalesData(VendingMachine vendingMachine) {
//        // Update the sales data (amount collected, timestamp, etc.)
//        vendingMachine.setDateAndTimeSold(vendingMachine.getDateAndTimeSold());
//        vendingMachineRepository.save(vendingMachine);
//    }
//
//    // Send Machine Updates (stock, sales, status) to an external API
//    public void sendMachineUpdates(Integer missionId) {
//        VendingMachine machine = vendingMachineRepository.findByMissionId(missionId)
//                .orElseThrow(() -> new RuntimeException("Vending machine not found"));
//          System.out.println("Sending updates for machine: " + missionId);
//    }
//
//    // Handle Dispense Command (after coin validation)
//    public void handleDispenseCommand(String dispenseCommand) {
//        // Logic to process the dispense command, e.g., reducing stock
//        System.out.println("Processing dispense command: " + dispenseCommand);
//    }
//}

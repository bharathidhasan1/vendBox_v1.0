package com.org.vendbox.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VendingMachineDTO {

	private Integer id;
	private Integer missionId;
	private String missionStatus;
	private String sizeOfProduct;
	private Integer totalStock;
	private Integer soldStock;
	private LocalDateTime dateAndTimeSold;
	private Integer currentStock;
	private String paymentMode;
	private String refillingAlert;
	private Boolean refillReset;

}


/*
 * INSERT INTO vending_machine ( mission_Id, mission_status, size_of_product,
 * total_stock, sold_stock, date_and_time_sold, current_stock, payment_mode,
 * refilling_alert, refill_reset ) VALUES (101, 'Active', 'XL', 100, 20,
 * '2024-02-23 14:30:00', 80, 'Cash', 'Low', FALSE), (102, 'Inactive', 'XXL',
 * 150, 50, '2024-02-22 10:15:00', 100, 'Card', 'Medium', TRUE), (103, 'Active',
 * 'XL', 200, 75, '2024-02-21 16:45:00', 125, 'UPI', 'High', FALSE), (104,
 * 'Maintenance', 'XXL', 120, 30, '2024-02-20 12:00:00', 90, 'Cash', 'Low',
 * TRUE), (105, 'Active', 'XL', 80, 10, '2024-02-19 18:20:00', 70, 'Card',
 * 'None', FALSE);
 */
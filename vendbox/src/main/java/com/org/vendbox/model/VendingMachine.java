package com.org.vendbox.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "vending_machine")
public class VendingMachine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "mission_Id", nullable = false)
	private Integer missionId;

	@Column(name = "mission_status", nullable = false)
	private String missionStatus;

	@Column(name = "size_of_product", nullable = false)
	private String sizeOfProduct;

	@Column(name = "total_stock", nullable = false)
	private Integer totalStock;

	@Column(name = "sold_stock", nullable = false)
	private Integer soldStock;

	@Column(name = "date_and_time_sold")
	private LocalDateTime dateAndTimeSold;

	@Column(name = "current_stock", nullable = false)
	private Integer currentStock;

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name = "refilling_alert")
	private String refillingAlert;

	@Column(name = "refill_reset")
	private Boolean refillReset;
}

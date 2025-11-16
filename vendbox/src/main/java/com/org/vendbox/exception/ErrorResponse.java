package com.org.vendbox.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author bharathidhasan_m
 */
@Data
@AllArgsConstructor
public class ErrorResponse {

	private String message;
	private List<String> details;
}

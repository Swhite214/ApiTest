package com.kh.memo.controller;

import org.springframework.web.bind.annotation.*;

import com.kh.memo.entity.ApiResponseEntity;
import com.kh.memo.service.ApiService;

@RestController
@RequestMapping("/api")

public class ApiController {
	private final ApiService apiService;
	
	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}
	@GetMapping("/fetch")
	public ApiResponseEntity fetchData() {
		return apiService.fetchAndSaveData();
	}
}

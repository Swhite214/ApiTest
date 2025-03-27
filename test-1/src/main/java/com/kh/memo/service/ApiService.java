package com.kh.memo.service;

import org.springframework.web.client.RestTemplate;

import com.kh.memo.entity.ApiResponseEntity;
import com.kh.memo.repository.ApiResponseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApiService {
	private final ApiResponseRepository repository;
	private final RestTemplate restTemplate;
	
	@Autowired
	public ApiService(ApiResponseRepository repository) {
		this.repository = repository;
		this.restTemplate = new RestTemplate();
	}
	public ApiResponseEntity fetchAndSaveData() {
		String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=1292a16846b3252f61d7d4f418306639&targetDt=20120101";
		String response = restTemplate.getForObject(url, String.class);
		
		ApiResponseEntity entity = new ApiResponseEntity();
		entity.setData(response);
		return repository.save(entity);
	}
}

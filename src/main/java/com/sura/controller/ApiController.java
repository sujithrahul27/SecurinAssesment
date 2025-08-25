package com.sura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sura.model.CpeDictnary;
import com.sura.service.CpeDbService;

@RestController
@RequestMapping("/api/cpes")
public class ApiController {
	@Autowired
	CpeDbService cpeDbService;
	
	
	@GetMapping
	public Page<CpeDictnary> getPaginatedCpes(@RequestParam int page,@RequestParam int limit){
		
	return cpeDbService.getPaginatedCpes(page,limit);
	}
	@GetMapping("/search")
	public List<CpeDictnary> getSearched(
			@RequestParam(required = false) String cpe_title,
			@RequestParam(required = false) String cpe_22_uri,
			@RequestParam(required = false) String cpe_23_uri,
			@RequestParam(required = false) String deprecation_date
			){
		return cpeDbService.searchCpes(cpe_title,cpe_22_uri,cpe_23_uri,deprecation_date);
	}
	
}


package com.sura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sura.model.CpeDictnary;
import com.sura.repo.CpeRepo;		//MYSQL DB SERVICE LAYER CONNECTED WITH REPO
@Service
public class CpeDbService {
	@Autowired
	CpeRepo repo;
	public List<CpeDictnary> saveCpes(List<CpeDictnary> cpes){  //TO SAVE ALL PARSED XML DATA
		repo.saveAll(cpes);
		return cpes;
	}
	public CpeDictnary saveCpe(CpeDictnary cpe) {
		repo.save(cpe);   //TO STORE ONE BY ONE THE XML DATA 
		return cpe;
	}
	public Page<CpeDictnary> getPaginatedCpes(int page, int limit) {
		return repo.findAll(PageRequest.of(page, limit).withSort(Sort.by("id"))); //GETTING PAGES FROM DB
	}
	public List<CpeDictnary> searchCpes(String cpe_title, String cpe_22_uri, String cpe_23_uri,
			String deprecation_date) {
		// TODO Auto-generated method stub
		return repo.searchByFields(cpe_title,cpe_22_uri,cpe_23_uri,deprecation_date); //GETTING SEARCH RESULT FROM DB
	}
}

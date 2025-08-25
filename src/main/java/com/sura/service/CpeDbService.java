package com.sura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sura.model.CpeDictnary;
import com.sura.repo.CpeRepo;
@Service
public class CpeDbService {
	@Autowired
	CpeRepo repo;
	public List<CpeDictnary> saveCpes(List<CpeDictnary> cpes){
		repo.saveAll(cpes);
		return cpes;
	}
	public CpeDictnary saveCpe(CpeDictnary cpe) {
		repo.save(cpe);
		return cpe;
	}
	public Page<CpeDictnary> getPaginatedCpes(int page, int limit) {
		return repo.findAll(PageRequest.of(page, limit).withSort(Sort.by("id")));
	}
}

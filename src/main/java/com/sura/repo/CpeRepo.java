package com.sura.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sura.model.CpeDictnary;
@Repository
public interface CpeRepo extends JpaRepository<CpeDictnary, String> {
	@Query(value = "SELECT * FROM cpe_dictnary WHERE cpe_title=?1 OR cpe_22_uri = ?2 OR cpe_23_uri = ?3 OR cpe_23_deprecation_date=?4 OR cpe_22_deprecation_date = ?4",nativeQuery=true)
	List<CpeDictnary> searchByFields(String cpe_title, String cpe_22_uri, String cpe_23_uri, String deprecation_date);

}

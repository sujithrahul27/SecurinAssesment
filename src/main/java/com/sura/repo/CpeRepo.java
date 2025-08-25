package com.sura.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sura.model.CpeDictnary;
@Repository
public interface CpeRepo extends JpaRepository<CpeDictnary, String> {

}

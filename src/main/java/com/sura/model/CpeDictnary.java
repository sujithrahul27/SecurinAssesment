package com.sura.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity(name ="cpe_dictnary")			//BASIC POJO CLASS
public class CpeDictnary {
	@Id
	private Long id;


	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCpe23Uri() {
		return cpe23Uri;
	}
	public void setCpe23Uri(String cpe23Uri) {
		this.cpe23Uri = cpe23Uri;
	}


	public LocalDate getDeprecatedDate23() {
		return deprecatedDate23;
	}
	public void setDeprecatedDate23(LocalDate deprecatedDate23) {
		this.deprecatedDate23 = deprecatedDate23;
	}
	@Column(name="cpe_title")
	private String title;
	
	@Column(name="cpe_23_uri")
	private String cpe23Uri;
	@Column(name="reference_links",length=1000)
	private String reference;
	@Column(name="cpe_23_deprecation_date")
	LocalDate deprecatedDate23;




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	@Override
	public String toString() {
		return "CpeDictnary [id=" + id + ", title=" + title + ", cpe23Uri=" + cpe23Uri + ", reference=" + reference
				+ ", deprecatedDate23=" + deprecatedDate23 + "]";
	}
	
	
	
}

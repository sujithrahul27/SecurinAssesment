package com.sura.model;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity(name ="cpe_dictnary")
public class CpeDictnary {
	@Id
	private String id;

	@Override
	public String toString() {
		return "CpeDictnary [id=" + id + ", title=" + title + ", cpe23Uri=" + cpe23Uri + ", cpe24Uri=" + cpe24Uri
				+ ", reference=" + reference + ", deprecatedDate22=" + deprecatedDate22 + ", deprecatedDate23="
				+ deprecatedDate23 + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getCpe24Uri() {
		return cpe24Uri;
	}
	public void setCpe24Uri(String cpe24Uri) {
		this.cpe24Uri = cpe24Uri;
	}
	public List<String> getReference() {
		return reference;
	}
	public void setReference(List<String> reference) {
		this.reference = reference;
	}
	public LocalDate getDeprecatedDate22() {
		return deprecatedDate22;
	}
	public void setDeprecatedDate22(LocalDate deprecatedDate22) {
		this.deprecatedDate22 = deprecatedDate22;
	}
	public LocalDate getDeprecatedDate23() {
		return deprecatedDate23;
	}
	public void setDeprecatedDate23(LocalDate deprecatedDate23) {
		this.deprecatedDate23 = deprecatedDate23;
	}
	@Column(name="cpe_title")
	private String title;
	@Column(name="cpe_22_uri")
	private String cpe23Uri;
	@Column(name="cpe_23_uri")
	private String cpe24Uri;
	@Column(name="reference_links")
	private List<String> reference;
	@Column(name="cpe_22_deprecation_date")
	LocalDate deprecatedDate22;
	@Column(name="cpe_23_deprecation_date")
	LocalDate deprecatedDate23;
	
}

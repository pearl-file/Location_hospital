package com.pearl_file.Site.Controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name="animal_hospital")
public class HospitalDto {
	
	@Id
	//JPA auto-increment, primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="FRNM_NM")
	private String frnmNm;
	@Column(name="RN_ADDR")
	private String rnAddr;
	@Column(name="OPR_TIME_INFO")
	private String oprTimeInfo;
	@Column(name="RPRS_TELNO")
	private String rprsTelNo;
	@Column(name="HMPG_URL")
	private String hmpgUrl;
	@Column(name="LA_VLUE")
	private Double laValue;
	@Column(name="LO_VLUE")
	private Double loValue;
	
	
	
	
}

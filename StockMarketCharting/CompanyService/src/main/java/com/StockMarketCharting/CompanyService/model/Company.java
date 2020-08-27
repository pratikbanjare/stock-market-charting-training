package com.StockMarketCharting.CompanyService.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id",nullable = false)
	private Integer companyId;
	
	@Column(name = "company_name",nullable = false)
	private String companyName;
	
	@Column(name = "turnover")
	private Long turnover;

	@Column(name = "ceo")
	private String ceo;
	
	@Column(name = "writeup")
	private String writeup;
	
	@Column(name = "company_code")
	private String companyCode;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinTable(name = "company_listing",
		joinColumns = @JoinColumn(name="id"),
		inverseJoinColumns = @JoinColumn(name= "company_id"))
	private List<Exchange> exchanges;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", nullable = true)
	private List<Director> directors;
	
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name = "company_id",nullable = true)
	private List<IpoDetail> ipoDetails;
	
}
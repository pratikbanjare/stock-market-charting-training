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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Exchange {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "exchange_name")
	private String exchangeName; 
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "company_listing",
			joinColumns = @JoinColumn(name="id"),
			inverseJoinColumns = @JoinColumn(name= "company_id"))
	private List<Company> companies;

}

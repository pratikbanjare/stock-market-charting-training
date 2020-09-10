package com.StockMarketCharting.CompanyService.service;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.StockMarketCharting.CompanyService.dao.CompanyDao;
import com.StockMarketCharting.CompanyService.model.Company;
import com.StockMarketCharting.CompanyService.model.Director;
import com.StockMarketCharting.CompanyService.shared.CompanyResponse;

public class CompanyServiceTest {

	@Mock
	public CompanyDao dao;
	@InjectMocks
	private CompanyServiceImpl service;
	
	//private Company c1 = new Company( 1, "Dianoia",100000L,"shw", "abrakadabra", "IN001" , Arrays.asList(new Director(2,"raghu")) );
	
	@Test
	public void assert_notNull () {
		MockitoAnnotations.initMocks(this);
		assertNotNull(service);
	}
	
	public void testFindAll(){
		MockitoAnnotations.initMocks(this);
		//given (dao.findAll()).willReturn( Arrays.asList(c1) );
		List<CompanyResponse> allCompany = (List<CompanyResponse>) service.findAllCompany();
		System.out.println( allCompany.size() );
		verify(dao, times(1)).findAll();
	}
	
	
	
}

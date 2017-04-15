package com.camcor.repository;

import com.camcor.AbstractTest;
import com.camcor.model.Agreement;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AgreementRepositoryIntegrationTests extends  AbstractTest {
	
	@Autowired
	AgreementRepository repository;
	
	@Test
	public void findsFirstPageOfAgreements() {
		Page<Agreement> agreements = this.repository.findAll(PageRequest.of(0, 10));
		assertThat(agreements.getTotalElements()).isEqualTo(2L);
	}
	
	@Test
	public void findAllAgreementByTenant(){
		List<Agreement> agreements = this.repository.findAllAgreementByTenant("Ericka");
		assertThat(agreements.size()).isEqualTo(1);
	}
	
}

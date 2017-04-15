package com.camcor.model;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.camcor.AbstractTest;
import com.camcor.model.Agreement;
import com.camcor.repository.PropertyRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class AgreementEntityTest extends AbstractTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
    
    @MockBean
    public PropertyRepository repo;
    
    public Date date;
    public BigDecimal price;
	
    @Before
	public void setUp() {
		date = Mockito.mock(Date.class);
		price = new BigDecimal(500.00);
	}
	
	@Test
	public void createWhenPropertyIsNullShouldThrowException() throws Exception {		
	    this.thrown.expect(IllegalArgumentException.class);
		new Agreement(new Person(), null , date, date, price, "");
	}
	
	@Test
	public void createWhenTenantIsNullShouldThrowException() throws Exception {		
	    
	    this.thrown.expect(IllegalArgumentException.class);
		new Agreement(null, new Property() , date, date, price, "");
	}
}

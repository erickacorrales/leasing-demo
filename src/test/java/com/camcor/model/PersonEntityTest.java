package com.camcor.model;

import com.camcor.AbstractTest;
//import com.camcor.model.Person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PersonEntityTest extends AbstractTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	public void createWhenDniIsNullShouldThrowException() throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("Dni must not be empty");
		new Person("NameTest", "LastNameTest",null,"12345678","Street Test");
	}

	@Test
	public void saveShouldPersistData() throws Exception {
		Person person = this.entityManager.persistFlushFind(new Person("NameTest", "LastNameTest","333333X","12345678","Street Test"));
		assertThat(person.getFirstName()).isEqualTo("NameTest");
		assertThat(person.getDni()).isEqualTo("333333X");
	}
}

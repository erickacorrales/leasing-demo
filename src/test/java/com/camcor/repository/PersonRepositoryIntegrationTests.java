package com.camcor.repository;

import com.camcor.AbstractTest;
import com.camcor.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonRepositoryIntegrationTests extends AbstractTest {


    @Autowired
    PersonRepository repository;

    @Test
    public void findByLastNameShouldReturnOnePerson() throws Exception {
        List<Person> people = this.repository.findByLastName("Skywalker");
        assertThat(people.size()).isEqualTo(1);

   }

    @Test
    public void findByLastNameWhenLastNameIsEmptyReturnZeroPeople() {
        List<Person> people = this.repository.findByLastName("");
        assertThat(people.size()).isEqualTo(0);
    }
}

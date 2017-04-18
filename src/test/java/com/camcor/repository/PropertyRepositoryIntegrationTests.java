package com.camcor.repository;

import com.camcor.AbstractTest;
import com.camcor.model.Property;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PropertyRepositoryIntegrationTests extends AbstractTest {

    @Autowired
    PropertyRepository repository;

    @Test
    public void findsFirstPageOfProperties(){
        Page<Property> properties = this.repository.findAll(PageRequest.of(0, 10));
        assertThat(properties.getTotalElements()).isEqualTo(4L);
    }

    @Test
    public void findAllPropertiesByType(){
        List<Property> properties = this.repository.findAllPropertiesByType("stand");
        assertThat(properties.size()).isEqualTo(2);
    }

}

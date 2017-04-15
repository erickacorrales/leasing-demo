package com.camcor;
import java.math.BigDecimal;
import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.camcor.model.Agreement;
import com.camcor.model.Person;
import com.camcor.model.Property;
import com.camcor.model.PropertyType;
import com.camcor.repository.AgreementRepository;
import com.camcor.repository.PersonRepository;
import com.camcor.repository.PropertyRepository;
import com.camcor.repository.PropertyTypeRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final PersonRepository repository;
	private final PropertyRepository propertyRepository;
	private final PropertyTypeRepository propertyTypeRepository;
	private final AgreementRepository agreementRepository;
	
	@Autowired
	public DatabaseLoader(PersonRepository repository, PropertyRepository propertyRepository, 
						PropertyTypeRepository propertyTypeRepository, AgreementRepository agreementRepository){
		this.repository = repository;
		this.propertyRepository = propertyRepository;
		this.propertyTypeRepository= propertyTypeRepository;
		this.agreementRepository = agreementRepository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		final Person ericka = this.repository.save(new Person("Ericka", "Corrales", "06637042R","644431446", "Plaza alcalde"));
		final Person carlos = this.repository.save(new Person("Carlos", "Camacho", "50222126Q","678269402", "Plaza Alcalde"));
		
		final PropertyType  stand = this.propertyTypeRepository.save(new PropertyType("stand"));
		final PropertyType  storage =  this.propertyTypeRepository.save(new PropertyType("storage"));
		
		this.propertyRepository.save(new Property( "Stand 2M", new BigDecimal(250.00),  stand, "descripcion 2M"));
		final Property stand4 = this.propertyRepository.save(new Property( "Stand 4M", new BigDecimal(500.00),  stand, "descripcion 4M"));

		this.propertyRepository.save(new Property( "Storage 3M", new BigDecimal(200.00),  storage, "descripcion 3M"));
		final Property storage5M = this.propertyRepository.save(new Property( "Storage 5M", new BigDecimal(400.00),  storage, "descripcion 5M"));

		
		//dates
		 String strDate = "2016-05-15", finDate="2017-05-15";
         java.util.Date dateStart = Date.valueOf(strDate);
         java.util.Date dateFin = Date.valueOf(finDate);

		this.agreementRepository.save(new Agreement(ericka, stand4, new Date(dateStart.getTime()), new Date(dateFin.getTime()), new BigDecimal(500.00), "Contrato Ericka"));
		this.agreementRepository.save(new Agreement(carlos, storage5M,new Date(dateStart.getTime()), new Date(dateFin.getTime()), new BigDecimal(400.00), "Contrato Carlos"));

	}
}

package com.camcor.model.projections;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.camcor.model.Agreement;


@Projection(name="agreementDetailView", types={Agreement.class})
public interface AgreementDetailView {

	@Value("#{target.tenant.firstName} #{target.tenant.lastName}")
	String getTenantFullName();

	@Value("#{target.property.description}")
	String getPropertyDescription();

	BigDecimal getPrice();
	
	@Value("#{ new java.text.SimpleDateFormat(\"dd-MM-yyyy\").format(target.dateOff)}")
	String getFormattedDateOff();
	
	@Value("#{ new java.text.SimpleDateFormat(\"dd-MM-yyyy\").format(target.dateOn)}")
	String getFormattedDateOn();
		
}

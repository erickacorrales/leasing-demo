package com.camcor.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camcor.model.Agreement;
import com.camcor.model.projections.AgreementDetailView;

@RepositoryRestResource(excerptProjection = AgreementDetailView.class)
public interface AgreementRepository extends PagingAndSortingRepository<Agreement, Long> {
	List<Agreement> findAllAgreementByTenant(@Param("name") String name);
}

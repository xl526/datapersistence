package com.dp.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dp.persistence.domain.DmonValue;

@Repository
public interface IDmonValueDao extends CrudRepository<DmonValue, Long> {
	
}

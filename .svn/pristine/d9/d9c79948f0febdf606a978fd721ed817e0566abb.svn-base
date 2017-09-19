package com.dp.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dp.persistence.domain.Equipment;

@Repository
public interface IEquipmentDao extends CrudRepository<Equipment, Long> {
	
	public List<Equipment> findByEname(String name);
	
}

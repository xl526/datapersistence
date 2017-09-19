package com.dp.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dp.persistence.domain.EquipmentStatus;

@Repository
public interface IEquipmentStatusDao extends CrudRepository<EquipmentStatus, Long> {

}

package com.dp.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dp.persistence.dao.IEquipmentStatusDao;
import com.dp.persistence.domain.EquipmentStatus;
import com.dp.persistence.service.EquipmentStatusService;

@Service
public class EquipmentStatusServiceImpl implements EquipmentStatusService {
	
	@Autowired
	private IEquipmentStatusDao equipmentStatusDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveEquipmentStatus(EquipmentStatus equipmentStatus) {
		equipmentStatusDao.save(equipmentStatus);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void deleteEquipmentStatus(Long id) {
		equipmentStatusDao.delete(id);
	}
	
}

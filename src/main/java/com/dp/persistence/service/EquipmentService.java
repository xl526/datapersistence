package com.dp.persistence.service;

import java.util.List;

import com.dp.persistence.domain.Equipment;
import com.dp.persistence.vo.EquipmentVO;

public interface EquipmentService {
	
	public void saveEquipment(Equipment equipment);
	
	public void deleteEquipment(Long id);
	
	public void batchSaveEquipment(List<EquipmentVO> equipments);
	
	public List<Equipment> findEquipmentByName(String name);
	
}

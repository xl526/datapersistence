package com.dp.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dp.persistence.dao.IEquipmentDao;
import com.dp.persistence.domain.Equipment;
import com.dp.persistence.domain.EquipmentStatus;
import com.dp.persistence.service.EquipmentService;
import com.dp.persistence.service.EquipmentStatusService;
import com.dp.persistence.vo.EquipmentVO;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private IEquipmentDao equipmentDao;
	
	@Autowired
	private EquipmentStatusService equipmentStatusService;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveEquipment(Equipment equipment) {
		equipmentDao.save(equipment);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void deleteEquipment(Long id) {
		equipmentDao.delete(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void batchSaveEquipment(List<EquipmentVO> equipments) {
		if (equipments != null && equipments.size() > 0) {
			for (EquipmentVO vo : equipments) {
				String ename = vo.getName();
				List<Equipment> list = findEquipmentByName(ename);
				Equipment equipment = null;
				if (list == null || list.size() == 0) {
					equipment = new Equipment();
					equipment.setEname(vo.getName());
					saveEquipment(equipment);
				} else {
					equipment = list.get(0);
				}
				
				List<EquipmentStatus> list1 = vo.getList();
				for (EquipmentStatus sta : list1) {
					sta.setEquipment(equipment.getId());
					equipmentStatusService.saveEquipmentStatus(sta);
				}
				
			}
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Equipment> findEquipmentByName(String name) {
		return equipmentDao.findByEname(name);
	}
	
}

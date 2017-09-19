package com.dp.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dp.persistence.dao.IDmonValueDao;
import com.dp.persistence.domain.DmonValue;
import com.dp.persistence.service.DmonValueService;

@Service
public class DmonValueServiceImpl implements DmonValueService {

	@Autowired
	private IDmonValueDao dmonValueDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveDmonValue(DmonValue dmonValue) {
		dmonValueDao.save(dmonValue);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void deleteDmonValue(Long id) {
		dmonValueDao.delete(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void batchSaveDmonValue(List<DmonValue> dmonValues) {
		if (dmonValues != null && dmonValues.size() > 0) {
			for (DmonValue d : dmonValues) {
				saveDmonValue(d);
			}
		}
	}

}

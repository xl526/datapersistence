package com.dp.persistence.service;

import java.util.List;

import com.dp.persistence.domain.DmonValue;

public interface DmonValueService {
	
	public void saveDmonValue(DmonValue dmonValue);
	
	public void deleteDmonValue(Long id);
	
	public void batchSaveDmonValue(List<DmonValue> dmonValues);
	
}

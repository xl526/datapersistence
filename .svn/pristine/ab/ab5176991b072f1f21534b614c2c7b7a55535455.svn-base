package com.dp.persistence.util;

import java.util.Calendar;

import com.dp.persistence.domain.DmonValue;
import com.dp.persistence.vo.DmonValueVO;

public class ObjectUtils {
	
	public static DmonValue convert2DmonValue(DmonValueVO vo) {
		DmonValue dmonValue = new DmonValue();
		dmonValue.setUid(vo.getId());
		dmonValue.setName(vo.getName());
		dmonValue.setGname(vo.getGname());
		dmonValue.setValue(vo.getValue());
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(vo.getT());
		dmonValue.setTimestamp(calendar.getTime());
		return dmonValue;
	}
}

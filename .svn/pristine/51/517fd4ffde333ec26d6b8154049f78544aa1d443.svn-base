package com.dp.persistence.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dp.persistence.domain.DmonValue;
import com.dp.persistence.domain.EquipmentStatus;
import com.dp.persistence.vo.DmonValueVO;
import com.dp.persistence.vo.EquipmentVO;

public class XMLUtils {
	
	public static List<EquipmentVO> parseEquipmentList(String source) throws DocumentException {
		
		List<EquipmentVO> equipments = new ArrayList<EquipmentVO>();
		Document document = DocumentHelper.parseText(source);
		Element root = document.getRootElement();

        for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
        	
        	EquipmentVO equipmentVO = new EquipmentVO();
            Element equipmentE = (Element) i.next();
            String equipmentName = equipmentE.elementText("name");  //name为设备标识
            equipmentVO.setName(equipmentName);
            
            //根据设备不同类型，持久化到不同表
            //String equipmentType = equipmentE.elementText("type");  //type为设备类型
            Element paramsE = equipmentE.element("params");
            List<EquipmentStatus> params = new ArrayList<EquipmentStatus>();
            
    		for ( Iterator j = paramsE.elementIterator(); j.hasNext(); ) {
    			Element paramE = (Element) j.next();
    			String paramName = paramE.elementText("name");
    			String paramValue = paramE.elementText("value");
    			
    			EquipmentStatus equipmentStatus = new EquipmentStatus();
    			equipmentStatus.setParam(paramName);
    			equipmentStatus.setValue(paramValue);
    			equipmentStatus.setRecordTime(new Date());
    			
    			params.add(equipmentStatus);
    		}
            
            equipmentVO.setList(params);
            equipments.add(equipmentVO);
        }
		
		return equipments;
		
	}
	
	public static List<DmonValue> parseDmonValueList(String source) {
		List<DmonValue> list = new ArrayList<DmonValue>();
		JSONArray jsonArray = JSONArray.parseArray(source);
		
		JSONArray array = jsonArray.getJSONArray(1);
		String boxUid = jsonArray.getString(2);
		for (int i = 0; i < array.size(); i++) {
			JSONObject json = array.getJSONObject(i);
			DmonValueVO dmonValueVO = JSONObject.toJavaObject(json, DmonValueVO.class);
			DmonValue dmonValue = ObjectUtils.convert2DmonValue(dmonValueVO);
			dmonValue.setBoxId(boxUid);
			list.add(dmonValue);
		}
		return list;
	}
	
	
	
}

package com.dingli.comment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.comment.bean.Legend;
import com.dingli.comment.bean.Option;
import com.dingli.comment.bean.Series;
import com.dingli.comment.bean.XAxis;
import com.dingli.comment.dao.OrderReportMapper;
import com.dingli.comment.service.OrderReportService;
@Service
public class ORServiceImpl implements OrderReportService {
	
	@Autowired
	private OrderReportMapper om;

	@Override
	public Option getReport() {
		
		Option op=new Option();
		List<Map<String, String>> datas=om.selectOrderReport();
		Legend le=new Legend();
		Map<String,String> reportMap=new HashMap<String,String>();
		for (Map<String, String> map : datas) {
			String cateName=map.get("category");
			le.getData().add(cateName);
			String hours=String.valueOf(map.get("orderTime"));
			String number=String.valueOf(map.get("num"));
			reportMap.put(cateName+"_"+hours,number);
		}
		op.setLegend(le);
		
		XAxis x=new XAxis();
		for(int i=0;i<24;i++){
			x.getData().add(String.format("%02d", i));
		}
		op.setxAxis(x);
		
		for (Object cateName : le.getData()) {
			Series s=new Series();
			s.setName(cateName.toString());
			//s.setStack("×ÜÁ¿");
			s.setType("line");
			for(Object hour:x.getData()){
				String key=cateName.toString()+"_"+hour.toString();
				String orderNum=reportMap.get(key);
				s.getData().add(orderNum==null?0:orderNum);
			}
			op.getSeries().add(s);
		}
		return op;
	}


}

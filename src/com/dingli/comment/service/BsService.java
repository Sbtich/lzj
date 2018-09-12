package com.dingli.comment.service;

import java.util.List;

import com.dingli.comment.bean.Business;
import com.dingli.comment.bean.BusinessDto;

public interface BsService {
	
	public List<Business> getBsList();
	
	public int deleted(int id);
	
	public List<Business> getOneList(String title);
	
	public boolean saveBs(BusinessDto bsDto);
	
	public BusinessDto getBsById(Business bs);
	
	public boolean updataBs(BusinessDto bsDto);

	public List<BusinessDto> getBusListForApi(BusinessDto dto);
	
	public List<BusinessDto> searchBsForApi(BusinessDto dto);
	
	public List<BusinessDto> searchBsForApi2(BusinessDto dto);
	
	public BusinessDto getBssById(BusinessDto dto);


}

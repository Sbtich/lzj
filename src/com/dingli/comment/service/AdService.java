package com.dingli.comment.service;

import java.util.List;

import com.dingli.comment.bean.Advance;
import com.dingli.comment.bean.AdvanceDto;

public interface AdService {
	
	public List<Advance> getAdList();
	
	public boolean saveAd(AdvanceDto adDto);
	
	public List<Advance> getOne(String title);
	
	public int deleted(int id);

	public AdvanceDto getAdById(Advance ad);
	
	public boolean updateAd(AdvanceDto adDto);

	public List<AdvanceDto> getAdListForApi();
}

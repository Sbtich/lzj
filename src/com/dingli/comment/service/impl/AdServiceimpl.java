package com.dingli.comment.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dingli.comment.bean.Advance;
import com.dingli.comment.bean.AdvanceDto;
import com.dingli.comment.dao.AdvanceMapper;
import com.dingli.comment.service.AdService;

@Service
public class AdServiceimpl implements AdService {
	@Value("${img_save_path}")
	private String filePath;
	
	@Value("${img_url}")
	private String imgUrl;

	@Autowired
	private AdvanceMapper am;
	
	@Override
	public List<Advance> getAdList() {
		List<Advance> ads=am.selectByAllAd(null);
		return ads;
	}

	@Override
	public boolean saveAd(AdvanceDto adDto) {
		Advance ad=new Advance();
		//这是页面上传过来的图片，暂时保存在内存中
		MultipartFile imgFile=adDto.getImgFile();
		String fileName=System.currentTimeMillis()+"_"+imgFile.getOriginalFilename();
		//判断文件是否为空
		if(null==imgFile||imgFile.getSize()==0){
			return false;
		}
		//加上时间戳，防止文件重名
		File saveFile=new File(filePath+fileName);
		//如果不存在，新建目录
		if(!saveFile.exists()){
			saveFile.mkdirs();
		}
		//将内存中文件转移到硬盘
		try {
			imgFile.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//拷贝文件信息
		BeanUtils.copyProperties(adDto, ad);
		ad.setImgFileName(fileName);
		//调用dao层，实现插入
		am.insert(ad);
		return true;
	}

	@Override
	public List<Advance> getOne(String title) {
		List<Advance> ad=am.selectByOne(title);
		return ad;
	}

	@Override
	public int deleted(int id) {
		return am.deleteById(id);
	}
	
	@Override
	public AdvanceDto getAdById(Advance ad) {
	Advance newAd=am.selectByPrimaryKey(ad.getId());
	AdvanceDto adDto=new AdvanceDto();
	BeanUtils.copyProperties(newAd, adDto);
	adDto.setImg_url(imgUrl+newAd.getImgFileName());
	return adDto;
	}

	@Override
	public boolean updateAd(AdvanceDto adDto) {
		Advance ad=new Advance();
		//这是页面上传过来的图片，暂时保存在内存中
		MultipartFile imgFile=adDto.getImgFile();
		String fileName=System.currentTimeMillis()+"_"+imgFile.getOriginalFilename();
		//判断文件是否为空
		if(null==imgFile||imgFile.getSize()==0){
			return false;
		}
		//加上时间戳，防止文件重名
		File saveFile=new File(filePath+fileName);
		//如果不存在，新建目录
		if(!saveFile.exists()){
			saveFile.mkdirs();
		}
		//将内存中文件转移到硬盘
		try {
			imgFile.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//拷贝文件信息
		BeanUtils.copyProperties(adDto, ad);
		ad.setImgFileName(fileName);
		//调用dao层，实现插入
		am.updateById(ad);
		return true;
	}

	@Override
	public List<AdvanceDto> getAdListForApi() {
		List<Advance> ads=am.selectByAllAd(null);
		List<AdvanceDto> adDtos=new ArrayList<AdvanceDto>();
		
		for(int i=0;i<ads.size();i++){
			AdvanceDto dto=new AdvanceDto();
			BeanUtils.copyProperties(ads.get(i), dto);
			dto.setImg(imgUrl+ads.get(i).getImgFileName());
			adDtos.add(dto);
		}
		return adDtos;
	}

}



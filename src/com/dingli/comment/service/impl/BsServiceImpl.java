package com.dingli.comment.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dingli.comment.bean.Business;
import com.dingli.comment.bean.BusinessDto;
import com.dingli.comment.dao.BusinessMapper;
import com.dingli.comment.service.BsService;
@Service
public class BsServiceImpl implements BsService {
	
	@Autowired
	private BusinessMapper bm;
	
	@Value("${bs_img_save_path}")
	private String filePath;
	
	@Value("${bs_img_url}")
	private String imgUrl;

	@Override
	public List<Business> getBsList() {
		List<Business> bss=bm.selectAllByBs(null);
		return bss;
	}

	@Override
	public int deleted(int id) {
		return bm.deleteById(id);
	}

	@Override
	public List<Business> getOneList(String title) {
		List<Business> bs1=bm.selectBytitle(title);
		return bs1;
	}

	@Override
	public boolean saveBs(BusinessDto bsDto) {
		Business bs=new Business();
		//����ҳ���ϴ�������ͼƬ����ʱ�������ڴ���
		MultipartFile imgFile=bsDto.getImgFile();
		String fileName=System.currentTimeMillis()+"_"+imgFile.getOriginalFilename();
		//�ж��ļ��Ƿ�Ϊ��
		if(null==imgFile||imgFile.getSize()==0){
			return false;
		}
		//����ʱ�������ֹ�ļ�����
		File saveFile=new File(filePath+fileName);
		//��������ڣ��½�Ŀ¼
		if(!saveFile.exists()){
			saveFile.mkdirs();
		}
		//���ڴ����ļ�ת�Ƶ�Ӳ��
		try {
			imgFile.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//�����ļ���Ϣ
		BeanUtils.copyProperties(bsDto, bs);
		bs.setImgFileName(fileName);
		//����dao�㣬ʵ�ֲ���
		bm.insert(bs);
		return true;
	}

	@Override
	public BusinessDto getBsById(Business bs) {
		Business newBs=bm.selectByPrimaryKey(bs.getId());
		BusinessDto bsDto=new BusinessDto();
		BeanUtils.copyProperties(newBs, bsDto);
		bsDto.setImg_url(imgUrl+newBs.getImgFileName());
		return bsDto;
	}

	@Override
	public boolean updataBs(BusinessDto bsDto) {
		Business bs=new Business();
		//����ҳ���ϴ�������ͼƬ����ʱ�������ڴ���
		MultipartFile imgFile=bsDto.getImgFile();
		String fileName=System.currentTimeMillis()+"_"+imgFile.getOriginalFilename();
		//�ж��ļ��Ƿ�Ϊ��
		if(null==imgFile||imgFile.getSize()==0){
			return false;
		}
		//����ʱ�������ֹ�ļ�����
		File saveFile=new File(filePath+fileName);
		//��������ڣ��½�Ŀ¼
		if(!saveFile.exists()){
			saveFile.mkdirs();
		}
		//���ڴ����ļ�ת�Ƶ�Ӳ��
		try {
			imgFile.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//�����ļ���Ϣ
		BeanUtils.copyProperties(bsDto, bs);
		bs.setImgFileName(fileName);
		//����dao�㣬ʵ�ֲ���
		bm.updateBsById(bs);
		return true;
	}

	@Override
	public List<BusinessDto> getBusListForApi(BusinessDto dto) {
		List<BusinessDto> busDtos=bm.selectLoveBs(dto);
		for(BusinessDto businessDto:busDtos){
			String LoveImagePath=imgUrl+businessDto.getImgFileName();
			businessDto.setImg(LoveImagePath);
		}
		return busDtos;
	}

	@Override
	public List<BusinessDto> searchBsForApi(BusinessDto dto) {
		List<BusinessDto> bsDtos=bm.searchBs(dto);
		for(BusinessDto businessDto:bsDtos){
			String SearchImgPath=imgUrl+businessDto.getImgFileName();
			businessDto.setImg(SearchImgPath);
		}
		return bsDtos;
	}

	@Override
	public List<BusinessDto> searchBsForApi2(BusinessDto dto) {
		List<BusinessDto> bsDtos=bm.searchBs2(dto);
		for(BusinessDto businessDto:bsDtos){
			String SearchImgPath=imgUrl+businessDto.getImgFileName();
			businessDto.setImg(SearchImgPath);
		}
		return bsDtos;
	}

	@Override
	public BusinessDto getBssById(BusinessDto dto) {
		Business bbus=bm.selectById(dto.getId());
		BusinessDto bsDto=new BusinessDto();
		BeanUtils.copyProperties(bbus, bsDto);
		bsDto.setImg(imgUrl+bbus.getImgFileName());
		return bsDto;

	}

}

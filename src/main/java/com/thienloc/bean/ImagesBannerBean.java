package com.thienloc.bean;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thienloc.enums.ImagesBannerType;
import com.thienloc.form.ImagesBannerForm;
import com.thienloc.mapper.ImagesBannerMapper;
import com.thienloc.model.ImagesBanner;
import com.thienloc.model.ImagesBannerExample;
import com.thienloc.utils.Upload;


@Transactional
@Repository
public class ImagesBannerBean {
	private static final String BANNER = "src/main/webapp/WEB-INF/images/banner";
	private static final String AVATAR = "src/main/webapp/WEB-INF/images/avatar";
	
	@Autowired
	ImagesBannerMapper mapper;
	
	public List<ImagesBanner> findAllImagesBanner() {
		List<Integer> types = new ArrayList<>();
		
		ImagesBannerType[] imagesBannerTypes = ImagesBannerType.values();
		for (ImagesBannerType item : imagesBannerTypes) {
			types.add(item.getCode());
		}
		
		if(mapper.countByExample(null) == 0) {
			createImagesBanner();
		}
		
		ImagesBannerExample example = new ImagesBannerExample();
		example.createCriteria().andImageTypeIn(types);
		
		return mapper.selectByExample(example);
	}
	
	public ImagesBanner findImagesBannerByType(Integer type) {
		ImagesBannerExample example = new ImagesBannerExample();
		example.createCriteria().andImageTypeEqualTo(type);
		
		List<ImagesBanner> list = mapper.selectByExample(example);
		
		return list.size() > 0 ? list.get(0) : null;
	}
	
	private void createImagesBanner() {
		ImagesBannerType[] imagesBannerTypes = ImagesBannerType.values();
		Date date = new Date();
		
		for (ImagesBannerType item : imagesBannerTypes) {
			ImagesBanner imagesBanner = new ImagesBanner();
			
			imagesBanner.setImageType(item.getCode());
			imagesBanner.setUpdatedDate(date);
			imagesBanner.setCreatedDate(date);
			
			mapper.insert(imagesBanner);
		}
	}

	public void saveData(ImagesBannerForm imagesBannerForm) throws IOException {
		Date date = new Date();
		
		if(imagesBannerForm.getBannerFile().getSize() > 0) {
			ImagesBanner imagesBanner = findImagesBannerByType(ImagesBannerType.BANNER.getCode());
			if(imagesBanner.getImageName() != null) {
				Upload.deleteFile(BANNER, imagesBanner.getImageName());
			}
			String name = "banner" + imagesBannerForm.getBannerFile().getContentType().replace("/", ".").substring(imagesBannerForm.getBannerFile().getContentType().indexOf("/"));
			
			imagesBanner.setImageName(name);
			imagesBanner.setContentType(imagesBannerForm.getBannerFile().getContentType());
			imagesBanner.setSize(imagesBannerForm.getBannerFile().getSize() / 1024);
			imagesBanner.setWidth(getWidth(imagesBannerForm.getBannerFile().getBytes()));
			imagesBanner.setHeight(getHeight(imagesBannerForm.getBannerFile().getBytes()));
			imagesBanner.setUpdatedDate(date);
			
			Upload.doUpload(imagesBannerForm.getBannerFile(), BANNER, name);
			
			mapper.updateByPrimaryKey(imagesBanner);
		}
		
		if(imagesBannerForm.getBannerSub1File().getSize() > 0) {
			ImagesBanner imagesBanner = findImagesBannerByType(ImagesBannerType.BANNER_SUB_1.getCode());
			if(imagesBanner.getImageName() != null) {
				Upload.deleteFile(BANNER, imagesBanner.getImageName());
			}
			String name = "banner-1" + imagesBannerForm.getBannerSub1File().getContentType().replace("/", ".").substring(imagesBannerForm.getBannerSub1File().getContentType().indexOf("/"));
			
			imagesBanner.setImageName(name);
			imagesBanner.setContentType(imagesBannerForm.getBannerSub1File().getContentType());
			imagesBanner.setSize(imagesBannerForm.getBannerSub1File().getSize() / 1024);
			imagesBanner.setWidth(getWidth(imagesBannerForm.getBannerSub1File().getBytes()));
			imagesBanner.setHeight(getHeight(imagesBannerForm.getBannerSub1File().getBytes()));
			imagesBanner.setUpdatedDate(date);
			
			Upload.doUpload(imagesBannerForm.getBannerSub1File(), BANNER, name);
			
			mapper.updateByPrimaryKey(imagesBanner);
		}
		
		if(imagesBannerForm.getBannerSub2File().getSize() > 0) {
			ImagesBanner imagesBanner = findImagesBannerByType(ImagesBannerType.BANNER_SUB_2.getCode());
			if(imagesBanner.getImageName() != null) {
				Upload.deleteFile(BANNER, imagesBanner.getImageName());
			}
			String name = "banner-2" + imagesBannerForm.getBannerSub2File().getContentType().replace("/", ".").substring(imagesBannerForm.getBannerSub2File().getContentType().indexOf("/"));
			
			imagesBanner.setImageName(name);
			imagesBanner.setContentType(imagesBannerForm.getBannerSub2File().getContentType());
			imagesBanner.setSize(imagesBannerForm.getBannerSub2File().getSize() / 1024);
			imagesBanner.setWidth(getWidth(imagesBannerForm.getBannerSub2File().getBytes()));
			imagesBanner.setHeight(getHeight(imagesBannerForm.getBannerSub2File().getBytes()));
			imagesBanner.setUpdatedDate(date);
			
			Upload.doUpload(imagesBannerForm.getBannerSub2File(), BANNER, name);
			
			mapper.updateByPrimaryKey(imagesBanner);
		}
		
		if(imagesBannerForm.getAvatarFile().getSize() > 0) {
			ImagesBanner imagesBanner = findImagesBannerByType(ImagesBannerType.AVATAR.getCode());
			if(imagesBanner.getImageName() != null) {
				Upload.deleteFile(AVATAR, imagesBanner.getImageName());
			}
			String name = "avatar" + imagesBannerForm.getAvatarFile().getContentType().replace("/", ".").substring(imagesBannerForm.getAvatarFile().getContentType().indexOf("/"));
			
			imagesBanner.setImageName(name);
			imagesBanner.setContentType(imagesBannerForm.getAvatarFile().getContentType());
			imagesBanner.setSize(imagesBannerForm.getAvatarFile().getSize() / 1024);
			imagesBanner.setWidth(getWidth(imagesBannerForm.getAvatarFile().getBytes()));
			imagesBanner.setHeight(getHeight(imagesBannerForm.getAvatarFile().getBytes()));
			imagesBanner.setUpdatedDate(date);
			
			Upload.doUpload(imagesBannerForm.getAvatarFile(), AVATAR, name);
			
			mapper.updateByPrimaryKey(imagesBanner);
		}
	}
	
	private int getHeight(byte[] bytes) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(bytes);
		BufferedImage image = ImageIO.read(inputStream);
		
		System.out.println(image.getHeight());
		
		return image.getHeight();
	}
	
	private int getWidth(byte[] bytes) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(bytes);
		BufferedImage image = ImageIO.read(inputStream);
		
		System.out.println(image.getWidth());
		
		return image.getWidth();
	}
}

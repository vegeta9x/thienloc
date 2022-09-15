package com.thienloc.form;

import org.springframework.web.multipart.MultipartFile;

public class ImagesBannerForm {
	private MultipartFile bannerFile;
	
	private MultipartFile bannerSub1File;
	
	private MultipartFile bannerSub2File;
	
	private MultipartFile avatarFile;

	public MultipartFile getBannerFile() {
		return bannerFile;
	}

	public void setBannerFile(MultipartFile bannerFile) {
		this.bannerFile = bannerFile;
	}

	public MultipartFile getBannerSub1File() {
		return bannerSub1File;
	}

	public void setBannerSub1File(MultipartFile bannerSub1File) {
		this.bannerSub1File = bannerSub1File;
	}

	public MultipartFile getBannerSub2File() {
		return bannerSub2File;
	}

	public void setBannerSub2File(MultipartFile bannerSub2File) {
		this.bannerSub2File = bannerSub2File;
	}

	public MultipartFile getAvatarFile() {
		return avatarFile;
	}

	public void setAvatarFile(MultipartFile avatarFile) {
		this.avatarFile = avatarFile;
	}
	
}

package com.thienloc.form;

import org.springframework.web.multipart.MultipartFile;

import com.thienloc.model.Blog;

public class BlogForm {
	private Long blogId;
	private String title;
	private String content;
	private Integer display;
	private String name;
	
	private MultipartFile fileData;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	public Integer getDisplay() {
		return display;
	}
	public void setDisplay(Integer display) {
		this.display = display;
	}
	
	public BlogForm() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public BlogForm(Blog blog) {
		this.blogId = blog.getBlogId();
		this.title = blog.getTitle();
		this.content = blog.getContent();
		this.display = blog.getDisplay();
		this.name = blog.getName();
	}
	
}

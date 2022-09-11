package com.thienloc.bean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thienloc.enums.Flag;
import com.thienloc.form.BlogForm;
import com.thienloc.mapper.BlogMapper;
import com.thienloc.model.Blog;
import com.thienloc.model.BlogExample;
import com.thienloc.utils.RemoveVietnameseTones;
import com.thienloc.utils.Upload;

@Transactional
@Repository
public class BlogBean {
	private static final String PATHNAME = "src/main/webapp/WEB-INF/images/blog";
	
	@Autowired
	BlogMapper blogMapper;
	
	public Blog findBlogByBlogId(Long blogId) {
		BlogExample example = new BlogExample();
		example.createCriteria()
			.andBlogIdEqualTo(blogId)
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		
		List<Blog> blogList = blogMapper.selectByExample(example);
		
		return blogList.size() > 0 ? blogList.get(0) : null;
	}
	
	public List<Blog> findAllBlog() {
		BlogExample example = new BlogExample();
		example.createCriteria()
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		example.setOrderByClause("blog_id ASC");
		
		List<Blog> blogList = blogMapper.selectByExample(example);
		
		return blogList;
	}
	
	public List<Blog> findAllViewBlog() {
		BlogExample example = new BlogExample();
		example.createCriteria()
			.andDisplayEqualTo(Flag.ON.getCode())
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		example.setOrderByClause("updated_date desc");
		
		List<Blog> blogList = blogMapper.selectByExample(example);
		
		return blogList;
	}
	
	public List<Blog> findBlogLimit(Long blogId, int limit) {
		BlogExample example = new BlogExample();
		example.createCriteria()
			.andBlogIdNotEqualTo(blogId)
			.andDeletedFlagEqualTo(Flag.OFF.getCode());
		example.setOrderByClause("updated_date desc");
		
		List<Blog> blogList = blogMapper.selectByExample(example);
		
		return blogList.size() > limit ? blogList.subList(0, limit) : blogList;
	}
	
	public void saveBlog(BlogForm blogForm) throws IOException {
		Date date = new Date();
		Blog blog = null;
        
        if(blogForm.getBlogId() != null) {
        	System.out.println("-----update-----");
        	blog = findBlogByBlogId(blogForm.getBlogId());
        	
        	blog.setTitle(blogForm.getTitle());
    		blog.setTitleCode(RemoveVietnameseTones.removeAccent(blogForm.getTitle()));
    		blog.setContent(blogForm.getContent());
    		if(blogForm.getFileData().getSize() > 0 ) {
    			Upload.deleteFile(PATHNAME, blog.getName());
    			
    			String name = "blog-" + blog.getBlogId().toString() + blogForm.getFileData().getContentType().replace("/", ".").substring(blogForm.getFileData().getContentType().indexOf("/"));
    			
    			blog.setName(name);
        		blog.setContentType(blogForm.getFileData().getContentType());
        		blog.setSize(blogForm.getFileData().getSize());
        		
        		Upload.doUpload(blogForm.getFileData(), PATHNAME, name);
    		}
    		
    		blog.setDisplay(blogForm.getDisplay());
        	blog.setUpdatedDate(date);
        	
        	blogMapper.updateByPrimaryKey(blog);
        	
        } else {
        	System.out.println("-----create-----");
        	blog = new Blog();
        	
        	blog.setTitle(blogForm.getTitle());
    		blog.setTitleCode(RemoveVietnameseTones.removeAccent(blogForm.getTitle()));
    		blog.setContent(blogForm.getContent());
    		blog.setDisplay(blogForm.getDisplay());
    		blog.setCreatedDate(date);
    		blog.setUpdatedDate(date);
    		blog.setDeletedFlag(0);
    		
    		blogMapper.insert(blog);
    		
    		if(blogForm.getFileData().getSize() > 0) {
    			String name = "blog-" + blog.getBlogId().toString() + blogForm.getFileData().getContentType().replace("/", ".").substring(blogForm.getFileData().getContentType().indexOf("/"));
        		
    			blog.setName(name);
        		blog.setContentType(blogForm.getFileData().getContentType());
        		blog.setSize(blogForm.getFileData().getSize());
        		blogMapper.updateByPrimaryKey(blog);
        		
        		Upload.doUpload(blogForm.getFileData(), PATHNAME, name);
    		}
        }
	}

	public void deleteBlogById(Blog blog) throws FileNotFoundException {
		Date date = new Date();
		
		blog.setDeletedFlag(Flag.ON.getCode());
		blog.setDeletedDate(date);
		blog.setUpdatedDate(date);
		
		Upload.deleteFile(PATHNAME, blog.getName());
		
		blogMapper.updateByPrimaryKey(blog);
		
	}
	
	
}

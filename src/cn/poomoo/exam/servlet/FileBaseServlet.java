/**
 * @fileName FileBaseServlet.java
 * @author YuanJingshan
 * @date 2014-12-9
 */
package cn.poomoo.exam.servlet;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.poomoo.common.util.LogUtil;

/**
 * @className FileBaseServlet
 * @description 文件上传相关基础servlet
 * @author YuanJingshan
 */
public class FileBaseServlet extends BaseServlet {

	//
	private static final long serialVersionUID = -8585607716221500880L;
	// 文件上传路径
	protected String filePath = null;
	// 文件上传临时路径
	protected String tempPath = null;
	// 表单值：存放表单内容，名字-内容
	protected List<String> formValues = new ArrayList<String>();
	// 上传文件名字
	protected String uploadFile = null; 
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 获取配置文件上传路径、临时文件
		filePath = config.getInitParameter("filepath");
		tempPath = config.getInitParameter("temppath");
		// 获取项目路径
		ServletContext context = getServletContext();
		filePath = context.getRealPath(filePath);
		tempPath = context.getRealPath(tempPath);
		// 文件路径不存在则创建
		if(!new File(filePath).isDirectory())
		    new File(filePath).mkdirs();
	    if(!new File(tempPath).isDirectory())
	        new File(tempPath).mkdirs();
	}
	
	/**
	 * 获取表单内容
	 */
	@SuppressWarnings("unchecked")
	protected void getFormValues(HttpServletRequest request) {
		try {
			DiskFileItemFactory disFactory = new DiskFileItemFactory();
			// threshold极限、临界值，即硬盘缓存3M
			disFactory.setSizeThreshold(1024 * 1024 * 8);
			// repository贮藏室，即临时文件目录
			disFactory.setRepository(new File(tempPath));

			ServletFileUpload upload = new ServletFileUpload(disFactory);
			// 设置utf-8编码，解决乱码问题
			upload.setHeaderEncoding("utf-8");
			// 设置允许上传文件的 最大文件大小8M
			upload.setSizeMax(8 * 1024 * 1024);

			// 解析Http请求消息头
			List fileItems = upload.parseRequest(request);
			Iterator iter = fileItems.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.getFieldName().equals("comfirm") && !item.getFieldName().equals("cancal")) {
					if (item.isFormField()) { // 处理表单内容
						formValues.add(new String(item.getString().getBytes("ISO-8859-1"), "utf-8"));
					} else { // 处理上传的文件内容
						// 完整的文件名
						String fileName = item.getName();
						int index = fileName.lastIndexOf("\\");
						fileName = fileName.substring(index + 1, fileName.length());
						long fileSize = item.getSize();

						if ("".equals(fileName) && fileSize == 0) {
							formValues.add("");
						} else {
							index = fileName.lastIndexOf(".");
							String lastName = fileName.substring(index,	fileName.length()); // 文件后缀
							String newname = UUID.randomUUID() + lastName; // 新文件名
							File uploadFile = new File(filePath + "\\" + newname);
							item.write(uploadFile);
							formValues.add(newname);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("使用组件fileupload时发生异常...");
		}
	}
	
	/**
	 * 获取表单内容
	 */
	@SuppressWarnings("unchecked")
	protected void uploadFile(HttpServletRequest request) {
		try {
			DiskFileItemFactory disFactory = new DiskFileItemFactory();
			// threshold极限、临界值，即硬盘缓存3M
			disFactory.setSizeThreshold(1024 * 1024 * 8);
			// repository贮藏室，即临时文件目录
			disFactory.setRepository(new File(tempPath));

			ServletFileUpload upload = new ServletFileUpload(disFactory);
			// 设置utf-8编码，解决乱码问题
			upload.setHeaderEncoding("utf-8");
			// 设置允许上传文件的 最大文件大小8M
			upload.setSizeMax(8 * 1024 * 1024);

			// 解析Http请求消息头
			List fileItems = upload.parseRequest(request);
			Iterator iter = fileItems.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) { // 处理表单内容
					// 完整的文件名
					String fileName = item.getName();
					int index = fileName.lastIndexOf("\\");
					fileName = fileName.substring(index + 1, fileName.length());
					long fileSize = item.getSize();

					if ("".equals(fileName) && fileSize == 0) {
						uploadFile = "";
					} else {
						index = fileName.lastIndexOf(".");
						String lastName = fileName.substring(index,	fileName.length()); // 文件后缀
						String newname = UUID.randomUUID() + lastName; // 新文件名
						File uploadFile = new File(filePath + "\\" + newname);
						item.write(uploadFile);
						this.uploadFile = newname;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("使用组件fileupload时发生异常...");
		}
	}
}

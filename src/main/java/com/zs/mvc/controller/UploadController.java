package com.zs.mvc.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	/**
	 * 普通文件上传
	 */
	@RequestMapping("/cupload/common.do")
	@ResponseBody
	public String commonUpload(MultipartFile file,HttpSessionRequest req) {
		//UUID算法生成前缀
		String pfix=UUID.randomUUID().toString();
		//生成的文件名 前缀+原始文件名
		String filename=pfix+file.getOriginalFilename();
		//获得upload文件夹的物理地址
		String path=req.getRealPath("upload");
		//创建文件
		File dfile=new File(path+File.separator+filename) ;
		try {
			//将上传的文件写入到目标文件中
		file.transferTo(dfile);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
	}
}

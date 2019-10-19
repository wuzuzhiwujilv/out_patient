package com.eye.op.common.utils;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Base64Utils;

public class DecodeUploadImgUtil {

	final static Logger logger = Logger.getLogger(DecodeUploadImgUtil.class);

	public static String DecodeBase64ToImg(String imgString,
			HttpServletRequest request) {

		String tempFileName = null;
		String dataPrix = "";
		String data = "";
		String uploadPath = "";
		try {
			if (imgString == null || "".equals(imgString)) {
				throw new Exception("上传失败，上传图片数据为空");
			} else {
				String[] d = imgString.split("base64,");
				if (d != null && d.length == 2) {
					dataPrix = d[0];
					data = d[1];
				} else {
					throw new Exception("上传失败，数据不合法");
				}
			}
			String suffix = "";
			if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {// data:image/jpeg;base64,base64编码的jpeg图片数据
				suffix = ".jpg";
			} else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {// data:image/x-icon;base64,base64编码的icon图片数据
				suffix = ".ico";
			} else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {// data:image/gif;base64,base64编码的gif图片数据
				suffix = ".gif";
			} else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {// data:image/png;base64,base64编码的png图片数据
				suffix = ".png";
			} else {
				throw new Exception("上传图片格式不合法");
			}
			tempFileName = UUID.randomUUID().toString() + suffix;

			// 因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
			byte[] bs = Base64Utils.decodeFromString(data);
			try {
				// 使用apache提供的工具类操作流
				uploadPath = request.getServletContext().getRealPath("/upload");
				FileUtils.writeByteArrayToFile(new File(uploadPath,
						tempFileName), bs);
			} catch (Exception ee) {
				throw new Exception("上传失败，写入文件失败，" + ee.getMessage());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uploadPath + tempFileName;

	}

}

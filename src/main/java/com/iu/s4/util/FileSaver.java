package com.iu.s4.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	public String save(String realpath, MultipartFile multipartFile) throws Exception{
		//파일 객체 생성
		File file = new File(realpath);
		
		//경로 유무 확인 후 없으면 생성
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//DB에 넣을 고유한 파일명 생성
		String filename = UUID.randomUUID().toString();
		
		//원래 파일명을 추가
		filename = filename+"_"+multipartFile.getOriginalFilename();
		
		//파일을 저장할 경로, 저장할 이름 지정
		file = new File(realpath, filename);
		
		//설정된 경로에 설정된 이름으로 파일 저장
		multipartFile.transferTo(file);
		
		return filename;
	}
}

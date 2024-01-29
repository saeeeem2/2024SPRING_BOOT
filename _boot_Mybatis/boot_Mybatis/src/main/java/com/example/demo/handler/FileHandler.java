package com.example.demo.handler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.BoardController;
import com.example.demo.domain.FileVO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@Component
public class FileHandler {
	
	private final Logger log = LoggerFactory.getLogger(BoardController.class);

	
	private String UP_DIR="D:\\_myProject\\_java\\_fileUpload";
	public List<FileVO> uploadFiles(MultipartFile[] files){
		List<FileVO>flist=new ArrayList<>();
		LocalDate date=LocalDate.now();
		String today=date.toString();
		//오늘 날짜를 파일의 경로 모양으로 변경하여 today에 저장
		today=today.replace("-", File.separator);
		//D:\_myProject\_java\_fileUpload\\2024\\01\29
		File folders = new File(UP_DIR,today);
		
		
		//실제 폴더를 생성하는 명령어 mkdir / mkdirs(여러 폴더 한 번에 생성)
		if(!folders.exists()) {
			folders.mkdirs();
		}
		
		//--------------------폴더 생성 완료
		
		//fileVO생성
		for(MultipartFile file:files) {
			FileVO fvo=new FileVO();
			fvo.setSaveDir(today);
			fvo.setFileSize(file.getSize());
			
			String originalFileName=file.getOriginalFilename();
			String onlyFileName=originalFileName.substring(originalFileName.lastIndexOf(File.separator)+1);
			fvo.setFileName(onlyFileName);
			
			UUID uuid=UUID.randomUUID();
			fvo.setUuid(uuid.toString());
			
			//-------------fvo설정 마무리
			
			//디스크에 저장할 파일 생성
			String fullFileName=uuid.toString()+"_"+onlyFileName;
			//D:\_myProject\_java\_fileUpload\\2024\\01\29//uuid_name
			File storeFile=new File(folders,fullFileName);
			
			//저장
			try {
				//원본파일 
				file.transferTo(storeFile);
				//file-type 이미지 파일이면 1, 아니면 0
				//이미지만 썸네일이 가능
				if(isImageFile(storeFile)) {
					fvo.setFileType(1);
					File thumbnail=new File(folders,uuid.toString()+"_th_"+onlyFileName);
					Thumbnails.of(storeFile).size(75,75).toFile(thumbnail);
				}
				
			} catch (Exception e) {
				log.info("파일 저장 오류");
				e.printStackTrace();
			}
		}
		
		return flist;
	}
	
	private boolean isImageFile(File file) throws IOException {
		String mimeType=new Tika().detect(file);
		return mimeType.startsWith("image")?true:false;
	}
}

package kr.co.recipetoyou.util;

import java.io.File;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import net.coobird.thumbnailator.Thumbnails;

/*
 * 폴더 생성, 파일 저장, 썸네일 생성 관련 클래스
 */
public class UploadFileUtils {
	
	
	static final int THUMBNAIL_WIDTH = 300;		//썸네일 가로 크기
	static final int THUMBNAIL_HEIGHT = 300; 	//썸네일 세로 크기

	public static String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath) throws Exception{
		
		//같은 파일명이라도 중복되지 않도록 랜덤 문자+파일명 조합한 뒤 생성 폴더에 저장
		UUID uid = UUID.randomUUID();
		
		String newFileName = uid + "_" + fileName;		//"랜덤문자+파일명"
		String imgPath = uploadPath + ymdPath;			//업로드 경로+연월일 경로 = 이미지 저장 경로
		
		//이미지 경로에 원본 파일을 저장하겠다.
		File target = new File(imgPath, newFileName);
		FileCopyUtils.copy(fileData, target);
		
		String thumbFileName = "s_" + newFileName;		//썸네일 파일명 = "s_파일명"
		File image = new File(imgPath+File.separator+newFileName);
		
		//원본 파일의 하위 경로에 "s"폴더를 생성하여 썸네일을 저장하겠다.
		File thumbnail = new File(imgPath+File.separator+"s"+File.separator+thumbFileName);
		
		if(image.exists()) {
			//썸네일 저장 폴더 생성
			thumbnail.getParentFile().mkdirs();
			//썸네일 생성
			Thumbnails.of(image).size(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT).toFile(thumbnail);
		}
		return newFileName;
	}
	
	public static String calcPath(String uploadPath) {
		
		//캘린더를 불러옴
		Calendar cal = Calendar.getInstance();
		
		//캘린더에서 연도만 추출
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		
		//캘린더에서 월만 추출, 형식은 00(01월, 02월...12월)
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		
		//캘린더에서 날짜만 추출
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		//원본 이미지 저장 경로 설정
		makeDir(uploadPath, yearPath, datePath);
		//썸네일 이미지 저장 경로 설정
		makeDir(uploadPath, yearPath, monthPath, datePath + "\\s");
		
		return datePath;
	}

	private static void makeDir(String uploadPath, String...paths) {
		
		//폴더가 존재하는지 확인, 폴더가 존재하면 그대로 종료
		if(new File(paths[paths.length -1]).exists()) {
			return;
		}
		//폴더가 존재하지 않는다면, 폴더 생성
		for(String path : paths) {
			File dirPath = new File(uploadPath+path);
			
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		
	}
}

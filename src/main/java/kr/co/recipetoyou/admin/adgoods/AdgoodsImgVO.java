package kr.co.recipetoyou.admin.adgoods;

public class AdgoodsImgVO {

	private String uploadPath;		//경로
	private String uuid;			//uuid
	private String fileName;			//이미지 이름
	private int prod_code;			//상품 코드
	
	
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getProd_code() {
		return prod_code;
	}
	public void setProd_code(int prod_code) {
		this.prod_code = prod_code;
	}
	
	
	
	
	
}

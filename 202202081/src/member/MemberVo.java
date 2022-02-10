package member;

public class MemberVo {
	private String id;
	private String pwd;
	
	public MemberVo(String id, String pwd, String addr) {
		this.id = id;
		this.pwd = pwd;
	}
	
	public String getid() {
		return id;
	}
	
	
	public String getpwd() {
		return pwd;
	}
}

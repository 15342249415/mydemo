package cn.tiange.mydemo.uitl;

public class CrowdException extends RuntimeException{

	/**
	 * Created by pxh on 17/10/31.
	 */
	private static final long serialVersionUID = 1L;
	
	private String exception;
	
	
	public String getException() {
		return exception;
	}

	public CrowdException(String exception) {
		super();
		this.exception=exception;
	}
}

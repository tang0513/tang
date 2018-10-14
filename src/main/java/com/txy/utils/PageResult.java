package com.txy.utils;
/**
 * ǰ��̨�����Ĺ淶
 * @author luqian
 *
 */
public class PageResult {
   
	private Integer code;//��Ӧ��״̬��
	private Boolean status;//ҵ��ִ���Ƿ�ɹ�
	private String msg;//��ʾ��Ϣ
	private Object data;//����ǰ̨������
	
	public PageResult() {
	
	}
	public PageResult(Integer code, Boolean status, String msg, Object data) {
		super();
		this.code = code;
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public static PageResult success(Object data){
		
		return new PageResult(200, true, "OK",data);
	}
	
	
    public static PageResult error(Integer code,String msg){
		
		return new PageResult(code, false, msg ,null);
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}

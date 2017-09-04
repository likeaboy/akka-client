package org.jrocky.akka.client;

import java.io.Serializable;
/**
 * 任务结果
 * @author rocky
 *
 */
public class JobResult implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3151999994317498070L;
	
	private int code;
	private String text;
	public JobResult(int code,String text){
		this.code = code;
		this.text = text;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
    public String toString() {
      return "code : "+code +"(" + text + ")";
    }
	
}

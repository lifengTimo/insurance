package com.lifeng.insurance.model;

import java.util.List;
/**
 * 分页返回信息
 * @author PA
 *
 */
public class PageReturn {

	private int total;
	private List<Object> rows;
	
	public PageReturn() {
		// TODO Auto-generated constructor stub
	}
	
	public PageReturn(int total, List<Object> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
	
	public static PageReturn instance(int total,List list){
		PageReturn pageReturn=new PageReturn(total, list);
		return pageReturn;
	}
}

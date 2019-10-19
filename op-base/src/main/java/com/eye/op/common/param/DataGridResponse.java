package com.eye.op.common.param;

import java.util.List;

@SuppressWarnings("rawtypes")
public class DataGridResponse {
	private List rows;
	private int total;
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}

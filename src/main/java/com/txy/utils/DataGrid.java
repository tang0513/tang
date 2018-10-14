package com.txy.utils;

import java.util.List;

public class DataGrid {

	private Long total;
	private List<?> rows;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "DataGrid [total=" + total + ", rows=" + rows + "]";
	}
	public DataGrid(Long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
}

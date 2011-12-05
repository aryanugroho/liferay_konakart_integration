package com.liferay.konakart.util;

import com.konakart.wsapp.DataDescriptor;
import com.konakart.app.DataDescConstants;

public class LDataDescriptor {
	
	public LDataDescriptor() {
		_dataDescriptor = new DataDescriptor();
		_dataDescriptor.setOffset(0);
		_dataDescriptor.setLimit(DataDescConstants.MAX_ROWS);
	}
	
	public LDataDescriptor(int limit) {
		_dataDescriptor = new DataDescriptor();
		_dataDescriptor.setOffset(0);
		_dataDescriptor.setLimit(limit);
	}
	
	public LDataDescriptor(int limit, String orderBy) {
		_dataDescriptor = new DataDescriptor();
		_dataDescriptor.setOffset(0);
		_dataDescriptor.setLimit(limit);
		_dataDescriptor.setOrderBy(orderBy);
	}
	
	public LDataDescriptor(String orderBy) {
		_dataDescriptor = new DataDescriptor();
		_dataDescriptor.setOffset(0);
		_dataDescriptor.setLimit(DataDescConstants.MAX_ROWS);
		_dataDescriptor.setOrderBy(orderBy);
	}
	
	public DataDescriptor get_dataDescriptor() {
		return _dataDescriptor;
	}

	public void set_dataDescriptor(DataDescriptor _dataDescriptor) {
		this._dataDescriptor = _dataDescriptor;
	}
	
	public void setOffset(int offset) {
		_dataDescriptor.setOffset(offset);
	}
	public void setOrderBy(String orderBy) {
		_dataDescriptor.setOrderBy(orderBy);
	}
	public void setLimit(int limit) {
		_dataDescriptor.setLimit(limit);
	}
	
	private DataDescriptor _dataDescriptor;
}

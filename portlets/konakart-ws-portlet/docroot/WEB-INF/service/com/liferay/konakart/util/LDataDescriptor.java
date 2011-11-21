package com.liferay.konakart.util;

import com.konakart.wsapp.DataDescriptor;

public class LDataDescriptor {
	
	public LDataDescriptor() {
		_dataDescriptor = new DataDescriptor();
		_dataDescriptor.setOffset(0);
		_dataDescriptor.setLimit(100);
	}
	public LDataDescriptor(int limit) {
		_dataDescriptor = new DataDescriptor();
		_dataDescriptor.setOffset(0);
		_dataDescriptor.setLimit(limit);
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
	
	public void setLimit(int limit) {
		_dataDescriptor.setLimit(limit);
	}
	
	private DataDescriptor _dataDescriptor;
}

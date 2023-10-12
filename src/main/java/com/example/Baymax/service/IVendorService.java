package com.example.Baymax.service;

import com.example.Baymax.model.Vendor;

public interface IVendorService {
	Vendor getVendorById(long id);

	Vendor getVendorByName(String name);

	String validateVendorId(long id);
	
	String validateVendorName(String vendorName);
}

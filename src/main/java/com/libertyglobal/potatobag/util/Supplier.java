package com.libertyglobal.potatobag.util;

/**
 * Enum for suppliers list
 * @author sindhu
 *
 */
public  enum Supplier {
	DE_COSTER("De Coster"),
	OWEL("Owel"),
	PATATAS_RUBEN("Patatas Ruben"),
	YUNNAN_SPICES("Yunnan Spices");	
	private final String supplierDisplayName;

	Supplier(String supplierDisplayName) {
		this.supplierDisplayName = supplierDisplayName;
	}
	public String getSupplierDisplayName() {
		return supplierDisplayName;
	}
	/**
	 * Comparing user input supplier with enum supplier 
	 * @param supplierDisplayName
	 * @return
	 */
	public static Supplier getSupplier(String supplierDisplayName) {
	    for (Supplier supplier : Supplier.values()) {
	        if (supplierDisplayName.equals(supplier.getSupplierDisplayName())) {
	            return supplier;
	        }
	    }
	    return null;
	}
}

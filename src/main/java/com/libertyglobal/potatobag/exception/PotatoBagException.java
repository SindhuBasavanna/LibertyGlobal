package com.libertyglobal.potatobag.exception;

import java.io.Serializable;

/**
 * CustomException
 * @author sindhu
 */
public class PotatoBagException extends Exception implements Serializable {
	private static final long serialVersionUID = 1L;

	public PotatoBagException(String s) {
		super(s);
	}

	public PotatoBagException(Throwable cause) {
		super(cause);
	}
}

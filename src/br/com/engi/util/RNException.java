package br.com.engi.util;

public class RNException extends Exception {

	private static final long serialVersionUID = -4223035969182634881L;

	public RNException() {
		super();
	}

	public RNException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public RNException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RNException(String arg0) {
		super(arg0);
	}

	public RNException(Throwable arg0) {
		super(arg0);
	}


}

package util;

public class ReleaseException extends Exception {

    private static final long serialVersionUID = 1L;

	public ReleaseException() {
	}

	public ReleaseException(String detailMessage) {
		super(detailMessage);
	}

	public ReleaseException(Throwable throwable) {
		super(throwable);
	}

	public ReleaseException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
}

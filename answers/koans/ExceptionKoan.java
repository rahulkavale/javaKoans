package koans;

import static org.junit.Assert.fail;

public class ExceptionKoan {

	private boolean active;
	
	public Object makeException() {
		return new RuntimeException();
	}
	
	public int divide(int numerator, int denominator) {
		return numerator / denominator;
	}
	
    public void throwException() throws IllegalAccessException {
    	throw new IllegalAccessException();
    }

    public int divideCatchingException(int numerator, int denominator) {
    	try {
    		return numerator / denominator;
    	} catch (ArithmeticException e) {
    		return Integer.MAX_VALUE;
    	}
    }
    
    public int divideWithoutCausingException(int numerator, int denominator) {
    	if (denominator == 0) {
    		return Integer.MAX_VALUE;
    	} else {
    		return numerator / denominator;
    	}
    }
    
    public void outerMethod() throws IllegalAccessException {
    	throwException();
    }
    
    public void rethrowException(boolean buryIt) throws IllegalAccessException {
    	try {
    		throwException();
    	} catch (IllegalAccessException e) {
    		if (!buryIt) {
    			throw e;
    		}
    	}
    }
    
    public void throwCheckedException() throws IllegalAccessException {
    	throw new IllegalAccessException();
    }
    
    public void throwUncheckedException() {
    	throw new ArithmeticException();
    }
    
    public void throwMyCheckedException() throws MyCheckedException {
    	throw new MyCheckedException();
    }
    
    public void throwMyUncheckedException() {
    	throw new MyUncheckedException();
    }

    public void throwMyFirstException() throws MyFirstException {
    	throw new MyFirstException();
    }
    
    public void throwMySecondException() throws MySecondException {
    	throw new MySecondException();
    }
    
    public void throwMySpecificException() throws MyGeneralException {
    	throw new MySpecificException();
    }
    
//    public void decide() {
//    	try {
//    		throw new MyMessageException("Kaboom");
//    	} catch (MyMessageException e) {
//    		if (e.getMessage().equals("Kaboom")) {
//    			fail ("Do not make a decision based on the message");
//    			// do something for a Kaboom exception
//    		} else {
//    			// do something for a general message
//    		}
//    	}
//    }

    public void decide() {
    	try {
    		throw new KaboomException();
    	} catch (KaboomException e) {
    			// do something for a Kaboom exception
    	} catch (MyMessageException e) {
    			// do something for a general message
    	}
    }
    
    public void throwExceptionWithCause() throws CausedException {
    	Exception cause = new IllegalAccessException();
    	throw new CausedException(cause);
    }
    
    public void throwRichException(int number) throws RichException {
    	throw new RichException(number);
    }
    
    public int useFinally(int numerator, int denominator)  {
    	active = true;
    	try {
    		return numerator / denominator;
    	} finally {
    		active = false;
    	}
    }
    
    public boolean isActive() {
    	return active;
    }
}


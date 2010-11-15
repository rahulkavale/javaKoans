package koans;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExceptionKoanTest {

    ExceptionKoan koan = new ExceptionKoan();

    @Test
    public void anExceptionIsAnInstanceOfAClass() {
    	Object actual = koan.makeException();
    	assertEquals ("RuntimeException", actual.getClass().getSimpleName());
    }

    @Test (expected=ArithmeticException.class)
    public void anExceptionIsThrownToCommunicateSomethingNotInTheNormalFlowOfLogic() {
        int numerator = 100;
        int denominator = 0;
        koan.divide(numerator, denominator);
    }

    @Test (expected=IllegalAccessException.class)
    public void youCanThrowAnExceptionFromYourCode() throws IllegalAccessException {
        koan.throwException();
    }

    @Test
    public void anExceptionCanBeCaughtIfYouKnowWhatToDoWithIt() {
        assertEquals(2, koan.divideCatchingException(10,5));
        assertEquals(Integer.MAX_VALUE, koan.divideCatchingException(1,0));
    }

    @Test
    public void howeverItsBestToAvoidTheExceptionIfPossible() {
        assertEquals(2, koan.divideWithoutCausingException(10,5));
        assertEquals(Integer.MAX_VALUE, koan.divideWithoutCausingException(1,0));
    }

    @Test 
    public void exceptionsThatAreNotCaughtArePassedOnToYourCaller() {
    	try {
    		koan.outerMethod();
    	} catch (IllegalAccessException e) {
    		// do nothing
    	}
    }

    @Test
    public void ifYouCatchAnExceptionButDoNotWantToHandleItAfterAllYouCanRethrowIt() {
    	try {
    		koan.rethrowException(false);
    	} catch (IllegalAccessException e) {
    		// do nothing
    	}
    }
   
    @Test (expected=IllegalAccessException.class)
    public void checkedExceptionsMustBeDeclaredInTheMethodSignature() throws Exception {
    	koan.throwCheckedException();
    }

    @Test (expected=ArithmeticException.class)
    public void uncheckedExceptionsMayBeDeclaredInTheSignatureButUsuallyAreNot() {
        koan.throwUncheckedException();
    }

    @Test
    public void youWillNormallyCreateYourOwnCheckedExceptionToThrow() {
    	try {
    		koan.throwMyCheckedException();
    		fail("did not throw exception");
    	} catch (MyCheckedException e) {
    		// do nothing
    	}
    }

    @Test (expected=MyUncheckedException.class)
    public void youCanCreateYourOwnUncheckedExceptionIfYouReallyDontExpectACallerToHandleIt() {
    	koan.throwMyUncheckedException();
    }
    
    @Test 
    public void youCanCatchMultipleExceptionsWithMultipleCatchBlocks() {
    	try {
    		koan.throwMyFirstException();
    		koan.throwMySecondException();
    	} catch (MyFirstException e1) {
    		// do something
    	} catch (MySecondException e2) {
    		// do something
    	}
    }

    @Test
    public void youCanCatchAnySubclassOfAnExceptionWithASingleCatchBlock() {
    	try {
    		koan.throwMySpecificException();
    	} catch (MyGeneralException e) {
    		assertEquals (MySpecificException.class, e.getClass());
    	}
    }

    @Test
    public void exceptionsHaveAFreeFormMessageForDisplayingToAHuman() {
    	try {
    		throw new MyMessageException("Kaboom");
    	} catch (MyMessageException e) {
    		assertEquals ("Kaboom", e.getMessage());
    	}
    }

    @Test
    public void doNotUseTheMessageToMakeADecision() {
    	koan.decide();
    }

    @Test
    public void exceptionsCanHaveACause() {
    	try {
    		koan.throwExceptionWithCause();
    	} catch (CausedException e) {
    		assertEquals (IllegalAccessException.class, e.getCause().getClass());
    	}
    }
    
    @Test
    public void exceptionsCanHaveOtherMethodsAndProperties() {
    	try {
    		koan.throwRichException(10);
    	} catch (RichException e) {
    		assertEquals(10, e.getNumber());	
    	}
    }
    
    @Test
    public void normallyAnExceptionWillSupportAnyCombinationOfMessageAndCause() {
    	ComprehensiveException ce;
    	String message = "something bad happened";
    	Throwable cause = new IllegalAccessException();
    	
    	ce = new ComprehensiveException();
    	ce = new ComprehensiveException(message);
    	ce = new ComprehensiveException(cause);
    	ce = new ComprehensiveException(message, cause);
    }
    
    @Test
    public void useFinallyToGuaranteeCleanUp() {
    	try {
    		koan.useFinally(1, 0);
    	} catch (ArithmeticException e) {
    		// do nothing
    	}
    	assertFalse(koan.isActive());
    }
}

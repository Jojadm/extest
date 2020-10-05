package be.abis.exercise.ut;

import be.abis.exercise.exceptions.SalaryTooLowException;
import be.abis.exercise.model.AbisPaymentService;
import be.abis.exercise.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {

    AbisPaymentService abisPaymentServiceUnderTest = new AbisPaymentService();

    @Mock
    Person personMock;

    @Test
    public void testpaymentService() throws SalaryTooLowException{

        when(personMock.calculateNetSalary()).thenReturn(1800.0);
        when(personMock.getFirstName()).thenReturn("Sonja");
        abisPaymentServiceUnderTest.paySalary(personMock);
    }

    @Test(expected=SalaryTooLowException.class)
    public void testpaymentServiceException() throws SalaryTooLowException {

        when(personMock.calculateNetSalary()).thenThrow(SalaryTooLowException.class);
        abisPaymentServiceUnderTest.paySalary(personMock);
    }
}


package be.abis.exercise.interfaces;

import be.abis.exercise.exceptions.SalaryTooLowException;
import be.abis.exercise.model.Person;

public interface PaymentService {

    public void paySalary(Person person) throws SalaryTooLowException;
}

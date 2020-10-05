package be.abis.exercise.model;

import be.abis.exercise.exceptions.SalaryTooLowException;
import be.abis.exercise.interfaces.PaymentService;

public class AbisPaymentService implements PaymentService {

    public void paySalary(Person person) throws SalaryTooLowException {
        double netSalary = person.calculateNetSalary();
        System.out.println("Paying " + netSalary + " to " + person.getFirstName());
    }
}
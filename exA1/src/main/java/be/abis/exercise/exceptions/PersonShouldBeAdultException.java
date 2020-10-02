package be.abis.exercise.exceptions;

public class PersonShouldBeAdultException extends Exception{
    public PersonShouldBeAdultException () {
        super("Person should be adult");
    }
}

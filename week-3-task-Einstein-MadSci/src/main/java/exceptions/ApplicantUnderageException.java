package exceptions;

public class ApplicantUnderageException extends Exception {
    public ApplicantUnderageException(){
        super("Applicant is underage and cannot be hired!");
    }
    public ApplicantUnderageException(String message){
        super(message);
    }
}

package services;

import entity.Cashier;
import entity.Manager;
import entity.PotentialCashier;
import exceptions.ApplicantUnderageException;
import interfaces.ManagerInterface;

public class ManagerServiceImpl implements ManagerInterface {
    private Manager manager;

    public ManagerServiceImpl(Manager manager) {
        this.manager = manager;
    }

    // If cashier has 3 strikes, he will be fired. The method below increments the cashier's strike count by one when
    // called. However, if the boolean value isFired is true before it is called, it prints the string cashier name
    // is already fired
    @Override
    public void strikeCashier(Cashier cashier){
        if (cashier.isFired()){
            System.out.printf("%s is already fired", cashier.getUserName());
        }else {
            cashier.setStrikeCount(cashier.getStrikeCount() + 1);
            if(cashier.getStrikeCount() == 0 || cashier.getStrikeCount() > 1)
                System.out.printf("%s has %d strikes\n", cashier.getUserName(), cashier.getStrikeCount());
            else
                System.out.printf("%s has %d strike\n", cashier.getUserName(), cashier.getStrikeCount());
        }
    }
    // The method below sets the boolean value isFired to true if strike count is greater than or equal to three
    // essentially firing the cashier
    // However, if the strike count is less than three, it will print the string cashier name cannot be fired
    @Override
    public void fireCashier(Cashier cashier){
        if (cashier.getStrikeCount() >= 3){
            cashier.setFired(true);
//            cashierList.remove();
            System.out.println(cashier.getUserName() + " has been fired");
        }else {
            System.out.println(cashier.getUserName() + " cannot be fired");
        }
    }
    //method below will hire a cashier based on age (i.e if applicant is older than or 18 years of age it will set the
    //    set hired boolean to true, otherwise it will print not hired
    @Override
    public void hireCashier(PotentialCashier applicant) throws ApplicantUnderageException {
        if (applicant.getAge() > 18){
            applicant.setHired(true);
            System.out.println(applicant.getUserName() + " is hired");
        }else {
            throw new ApplicantUnderageException(applicant.getUserName() + " is under 18 years of age and cannot be hired!");
        }
    }
}
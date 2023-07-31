package interfaces;

import entity.Cashier;
import entity.PotentialCashier;
import exceptions.ApplicantUnderageException;

public interface ManagerInterface {
//    method to strike cashier which allows a cashier to be fired
    void strikeCashier(Cashier cashier);
//    method to fire cashier (on getting three strikes)
    void fireCashier(Cashier cashier);
//    method to hire cashier based on age
    void hireCashier(PotentialCashier applicant) throws ApplicantUnderageException;
}

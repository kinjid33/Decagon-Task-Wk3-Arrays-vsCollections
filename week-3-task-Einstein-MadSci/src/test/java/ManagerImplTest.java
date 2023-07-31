import entity.Cashier;
import entity.Manager;
import entity.PotentialCashier;
import entity.Store;
import exceptions.ApplicantUnderageException;
import org.junit.Before;
import org.junit.Test;
import services.CashierServiceImpl;
import services.ManagerServiceImpl;
import services.StoreServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ManagerImplTest {
    Cashier cashier;
    Manager manager;
    PotentialCashier applicant;
    Store store;
    CashierServiceImpl cashServ;
    ManagerServiceImpl managerServ;
    StoreServiceImpl storeServ;
    @Before
    public void createManager() {
        applicant = new PotentialCashier("Olaide", 20,store);
        cashier = new Cashier("Olumide", store);
        manager = new Manager("dada", store);
        store = new Store();
        cashServ = new CashierServiceImpl(cashier);
        managerServ = new ManagerServiceImpl(manager);
        storeServ = new StoreServiceImpl(store);
    }
    @Test
    public void testManagerUsername(){
        assertEquals("dada", manager.getUserName());
    }
    @Test
    public void canStrikeCashier(){
        managerServ.strikeCashier(cashier);
        assertEquals(1, cashier.getStrikeCount());
    }
    @Test
    public void canHireCashier(){
        try {
            managerServ.hireCashier(applicant);
        } catch (ApplicantUnderageException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(applicant.isHired());
    }
    @Test
    public void canFireCashier(){
        managerServ.strikeCashier(cashier);
        managerServ.strikeCashier(cashier);
        managerServ.strikeCashier(cashier);
        managerServ.fireCashier(cashier);
        assertTrue(cashier.isFired());
    }
}
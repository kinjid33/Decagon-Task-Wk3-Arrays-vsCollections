package entity;

public class PotentialCashier extends Cashier {
    private boolean isHired = false;
    private int age;

    public boolean isHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PotentialCashier(String userName, int age, Store store) {
        super(userName, store);
        this.age = age;
    }
}


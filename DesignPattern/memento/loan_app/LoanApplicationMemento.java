package memento.loan_app;

public final class LoanApplicationMemento {

    private final String customerName;
    private final String pan;
    private final String aadhaarStatus;

    public LoanApplicationMemento(String customerName, String pan, String aadhaarStatus) {
        this.customerName = customerName;
        this.pan = pan;
        this.aadhaarStatus = aadhaarStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPan() {
        return pan;
    }

    public String getAadhaarStatus() {
        return aadhaarStatus;
    }
}

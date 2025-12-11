package memento.loan_app;

public class LoanApplication {

    private String customerName;
    private String pan;
    private String aadhaarStatus;

    public LoanApplication(){}

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public void setAadhaarStatus(String aadhaarStatus) {
        this.aadhaarStatus = aadhaarStatus;
    }


    public LoanApplication(String customerName, String pan, String aadhaarStatus) {
        this.customerName = customerName;
        this.pan = pan;
        this.aadhaarStatus = aadhaarStatus;
    }

    public LoanApplicationMemento getState(){
        return new LoanApplicationMemento(this.customerName, this.pan, this.aadhaarStatus);
    }

    public void restoreState(LoanApplicationMemento loanMemento){
        this.customerName = loanMemento.getCustomerName();;
        this.aadhaarStatus = loanMemento.getAadhaarStatus();
        this.pan = loanMemento.getPan();;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "aadhaarStatus='" + aadhaarStatus + '\'' +
                ", customerName='" + customerName + '\'' +
                ", pan='" + pan + '\'' +
                '}';
    }
}

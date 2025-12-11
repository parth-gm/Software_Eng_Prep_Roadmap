package memento.loan_app;

public class MainDemo {

    public static void main(String[] args) {

        LoanApplication loanApplication = new LoanApplication();
        LoanManager loanManager = new LoanManager();
        loanApplication.setPan("ABCD1");
        loanManager.pushLoanAppVersion(loanApplication);
        loanApplication.setPan("PAN1");
        loanApplication.setAadhaarStatus("Rejected");
        loanManager.pushLoanAppVersion(loanApplication);

        loanApplication.setCustomerName("Parth");
        loanManager.pushLoanAppVersion(loanApplication);

        loanManager.undo(loanApplication);
        System.out.println(loanApplication.toString());

        loanManager.undo(loanApplication);
        System.out.println(loanApplication.toString());

        loanManager.undo(loanApplication);
        System.out.println(loanApplication.toString());

    }

}

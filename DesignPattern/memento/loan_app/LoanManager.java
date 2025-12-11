package memento.loan_app;

import java.util.Stack;

public class LoanManager {

    private final Stack<LoanApplicationMemento>  loanAppHistory;

    public LoanManager() {
        this.loanAppHistory = new Stack<>();
    }

    public void pushLoanAppVersion(LoanApplication loanApplication){
        loanAppHistory.push(loanApplication.getState());
    }

    public void undo(LoanApplication app){
        if(!loanAppHistory.isEmpty()){
            app.restoreState(loanAppHistory.pop());
        }
    }

}

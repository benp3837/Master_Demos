package org.fnma.models;

public class Loan {

    private int loanId;
    private int loanAmount;
    private String loanReason;

    public Loan() {
    }

    public Loan(int loanId, int loanAmount, String loanReason) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.loanReason = loanReason;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanReason() {
        return loanReason;
    }

    public void setLoanReason(String loanReason) {
        this.loanReason = loanReason;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanAmount=" + loanAmount +
                ", loanReason='" + loanReason + '\'' +
                '}';
    }
}

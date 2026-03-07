package models;

import java.util.ArrayList;
import java.util.List;

public class Patron {

    private String id;
    private String name;
    private String email;
    private List<Loan> borrowHistory;

    public Patron(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowHistory = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Loan> getBorrowHistory() {
        return borrowHistory;
    }

    public void addLoan(Loan loan) {
        borrowHistory.add(loan);
    }
}
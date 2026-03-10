package services;

import models.Patron;
import java.util.*;

public class PatronService {

    private Map<String, Patron> patrons = new HashMap<>();

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public Patron getPatron(String id) {
        return patrons.get(id);
    }
}
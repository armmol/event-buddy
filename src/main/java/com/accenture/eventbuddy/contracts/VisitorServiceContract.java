package com.accenture.eventbuddy.contracts;

import com.accenture.eventbuddy.models.Visitor;

import java.util.List;

public interface VisitorServiceContract {

    void storeVisitor(Visitor visitor);

    Visitor getById(Long id);

    public List<Visitor> all();

    public void deleteById(Long id);
}

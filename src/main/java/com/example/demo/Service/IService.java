package com.example.demo.Service;

import com.example.demo.entities.Employee;

import java.util.List;

public interface IService<T> {
    public boolean createEmployee(T t) ;
    public List<T> listerEmployee();
    public List<T> listerAnniceir();
}

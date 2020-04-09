/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Abood Sh
 */
public class StreamFilter {

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args) {
        Employee[] employees = {
            new Employee(1, "Abood ", "opt", 1300),
            new Employee(2, "Ibrahem", "programming", 900),
            new Employee(5, "Ahmed", "IT", 1000),
            new Employee(7, "malak", "medicine", 1500),
            new Employee(4, "Amer", "Teacher", 1050)
        };
        List<Employee> listEmployees = Arrays.asList(employees);listEmployees
                .stream()
                .filter(e -> e.getSalary() >= 800 && e.getSalary() < 1200)
                .map(e -> new Employee(e.getId(), e.getName(), e.getDepartment(), e.getSalary() * 1.02))
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
                .forEach((d, c) -> System.out.println("Dept: " + d + ", Count: " + c));

    }
    
}
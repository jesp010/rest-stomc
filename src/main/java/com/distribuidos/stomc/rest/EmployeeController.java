package com.distribuidos.stomc.rest;

import dominio.Employee;
import negocio.EmployeeJpaController;
import negocio.EntityManagerFactoryBase;
import negocio.exceptions.NonexistentEntityException;
import negocio.exceptions.PreexistingEntityException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EntityManagerFactoryBase emf;
    private EmployeeJpaController ec;

    public EmployeeController() {
        emf = EntityManagerFactoryBase.getInstance();
        ec = new EmployeeJpaController(emf.getEmf());
    }

    @GetMapping("/")
    public ArrayList<Employee> read() {
        ArrayList<Employee> employees = new ArrayList<Employee>(ec.findEmployeeEntities());
        return employees;
    }

    @GetMapping("/{id}")
    public Employee read(@PathVariable Long id) {
        return ec.findEmployee(id);
    }

    @PostMapping("/")
    public RedirectView create(@RequestBody Employee employee)
            throws URISyntaxException, PreexistingEntityException {
        try {
            ec.create(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("/employees");
    }

    @PutMapping("/{id}")
    public RedirectView update(@RequestBody Employee employee, @PathVariable Long id) throws NonexistentEntityException, PreexistingEntityException, Exception {
        try {
            ec.edit(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("/employees");
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteStudent(@PathVariable Long id) {
        try {
            ec.destroy(id);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new RedirectView("/employees");
    }

    public Employee auth(String account, String password){
        try {
            ArrayList<Employee> employees = new ArrayList<Employee>(ec.findEmployeeByaccountAndPassword(account, password));
            Employee tempEmployee = new Employee(0L, null, null, null, null, null, null, null, null, null);
            if(employees.get(0) != null){
                tempEmployee.setAccount(account);
                return tempEmployee;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

package com.food.machine.service;

import com.food.machine.Repository.EmployeeRepository;
import com.food.machine.entity.EmployeeDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    @SuppressWarnings("All")
//    public List<EmployeeDetailsEntity> filterSalaryBase(EmployeeDetailsEntity employeeDetailsEntity) {
//        List<EmployeeDetailsEntity> employeeList = employeeRepository.findAll();
//        return employeeList.stream()
//                .filter(employee -> employee.getSalary() < 5000)
//                .collect(Collectors.toList());
//    }
    public List<EmployeeDetailsEntity> filterSalaryBase(double salaryThreshold) {
        String name = "Naga Pavan".toLowerCase();
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char ch: name.toCharArray()){
            letterCount.put(ch, letterCount.getOrDefault(ch, 0)+1);
        }
        for (Map.Entry<Character, Integer>entry: letterCount.entrySet()){
            System.out.println(entry.getKey()+": " + entry.getValue());
        }

        return employeeRepository.findEmployeesWithSalaryLessThan(salaryThreshold);
    }

    @Override
    public EmployeeDetailsEntity saveEmployees(EmployeeDetailsEntity employeeDetails) {
        ArrayList<Pulsar> pulsars = new ArrayList<>();
        pulsars.add(new Pulsar(50,60,100,30));
        System.out.println(pulsars);
        Map<Character, Integer> pulsarCount = new HashMap<>();

        return employeeRepository.save(employeeDetails);
    }

}

@SuppressWarnings("All")
class Pulsar{
    int ns160;
    int pulsar150;
    int ns200;
    int pulsar120;

    public Pulsar(int pulsar150, int ns160, int ns200, int pulsar120) {
        this.pulsar150 = pulsar150;
        this.ns160 = ns160;
        this.ns200 = ns200;
        this.pulsar120 = pulsar120;
    }

    public int getPulsar150() {
        return pulsar150;
    }

    public void setPulsar150(int pulsar150) {
        this.pulsar150 = pulsar150;
    }

    public int getNs160() {
        return ns160;
    }

    public void setNs160(int ns160) {
        this.ns160 = ns160;
    }

    public int getNs200() {
        return ns200;
    }

    public void setNs200(int ns200) {
        this.ns200 = ns200;
    }

    public int getPulsar120() {
        return pulsar120;
    }

    public void setPulsar120(int pulsar120) {
        this.pulsar120 = pulsar120;
    }

    @Override
    public String toString() {
        return "Pulsar{" +
                "pulsar150='" + pulsar150 + '\'' +
                ", ns160='" + ns160 + '\'' +
                ", ns200='" + ns200 + '\'' +
                ", pulsar120='" + pulsar120 + '\'' +
                '}';
    }
}

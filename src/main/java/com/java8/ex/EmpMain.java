package com.java8.ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmpMain {

    public static void main (String[]args) {

       Employee getEmpResult = new Employee();
       List<Employee> getAllEmpResult = getEmpResult.getAllEmp();

        //input array:[1,9,10,20,25,30,15,35]
        //required sum:35
        //output:[[20,15][30,5],[35,0]]

        Employee emp = getAllEmpResult.stream().findFirst().get();
        String fullName = emp.firstName + emp.lastName;
        System.out.println("fullname == "+fullName);

        System.out.println("count=="+getAllEmpResult.stream().filter(d -> d.getDepartment().equalsIgnoreCase("account"))
                .filter(d -> d.getDepartment().equalsIgnoreCase("IT"))
                .map(employee -> employee.department).count());

        Map<Object, Long> empMap = getAllEmpResult.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
       // Map<String, Long> empMap1 = getAllEmpResult.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println("department wise employee count == "+empMap);

       // 3)Given a map with the department name as key and value as list of employees belonging to that department.
       // when a search string is given, need to list out the employees whose firstname or lastname is matching(match should be case insensitive).


        Map<String, List<Employee>> empMap2 = getAllEmpResult.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));

         List<Employee> empMa1p2 = empMap2.entrySet().stream().filter(e->e.getKey().equalsIgnoreCase("IT")).findFirst().get().getValue()
                .stream().filter(e->e.getFirstName().equalsIgnoreCase("cherry")).collect(Collectors.toList());

        for (Employee e : empMa1p2)
        {
            System.out.println("employee firstname=="+e.getFirstName()+" == and department name=="+e.getDepartment());
        }

//        Set<Map.Entry<String, List<Employee>>> entrySet = empMap2.entrySet();
//
//        for (Map.Entry<String, List<Employee>> entry : entrySet)
//        {
//            System.out.println("--------------------------------------");
//
//            System.out.println("Employees In "+entry.getKey() + " : ");
//
//            System.out.println("--------------------------------------");
//
//            List<Employee> list = entry.getValue();
//
//            for (Employee e : list)
//            {
//                System.out.println("firsstname=="+e.getFirstName());
//            }
//        }

        //4)Store ids are of 4 digit strings.if length of given storeId is less than 4 digits,you need to prefix with zeros and return a 4 digit storeId.

        List<String> storeIds = Arrays.asList("11","22","33","","333");

//        String formatted = String.format("%04d", "121");
//        System.out.println(formatted);

        storeIds.stream().forEach(s -> {
            if (s.length() < 4) {
                for (int i =0; s.length() <4; i++)
                s = addPrefix(s);
            }
            System.out.println("=adding prefix==="+s);
        });

        //5)Consider a list of employees, and if a department name is given as argument, list out the employees which doesn't belong to that department.

        List<Employee> listEmp= getAllEmpResult.stream()
                .filter(e -> !e.getDepartment().equalsIgnoreCase("IT")).collect(Collectors.toList());

        listEmp.stream().forEach(employee -> {
            System.out.println("first name=="+employee.getFirstName()+" == last name =="+employee.getLastName() + " department==" + employee.getDepartment());
        });

        // 6)Consider a list of employees, sort the employees by their firstName and return the sorted list of employees.



        List<Employee> sortedEmpList = getAllEmpResult.stream(Comparator.comparing(Function.identity(), (o1, o2) -> o2.)).collect(Collectors.toList());
        System.out.println("sortedemp == "+sortedEmpList);
    }

    public static String addPrefix (String s) {
       // System.out.println("calling s length in addPrefix=="+s.length() +" value is == "+s);
        return "0"+s;
    }


}

package dto;

import proxy.EmploySalaryWithProxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        ItEmployee itEmployee=new ItEmployee();
        itEmployee.giveHike(500);

        IEmployee realSubject = new ItEmployee();

        IEmployee proxy = (IEmployee) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                new EmploySalaryWithProxy(realSubject));
        passMeAProxy(proxy);
        System.out.println(proxy.getSalary());

    }
    private static void passMeAProxy(IEmployee ie) {
        ie.giveHike(201);
    }
}


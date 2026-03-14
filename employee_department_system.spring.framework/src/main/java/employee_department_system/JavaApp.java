package employee_department_system;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaApp {

    static Map<Integer, Department> deptMap = new HashMap<>();
    static Map<Integer, Employee> empMap = new HashMap<>();

    static int deptId = 101;
    static int empId = 501;

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n1.Add Department");
            System.out.println("2.Add Employee");
            System.out.println("3.Update Employee Salary");
            System.out.println("4.Delete Employee");
            System.out.println("5.Exit");

            System.out.println("Enter Choice:");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.println("Enter Department Name:");
                    String name = sc.next();

                    System.out.println("Enter Location:");
                    String location = sc.next();

                    Department dept = context.getBean("department", Department.class);

                    dept.setId(deptId++);
                    dept.setName(name);
                    dept.setLocation(location);

                    deptMap.put(dept.getId(), dept);

                    System.out.println("Department added successfully");

                    break;

                case 2:

                    System.out.println("Enter Employee Name:");
                    String empName = sc.next();

                    System.out.println("Enter Salary:");
                    double salary = sc.nextDouble();

                    System.out.println("Enter Department ID:");
                    int dId = sc.nextInt();

                    Department d = deptMap.get(dId);

                    if(d == null) {
                        System.out.println("Department not found");
                        break;
                    }

                    Employee emp = context.getBean("employee", Employee.class);

                    emp.setId(empId++);
                    emp.setName(empName);
                    emp.setSalary(salary);
                    emp.setDepartment(d);

                    empMap.put(emp.getId(), emp);

                    System.out.println("Employee added successfully");

                    displayEmployee(emp);

                    break;

                case 3:

                    System.out.println("Enter Employee ID:");
                    int eId = sc.nextInt();

                    System.out.println("Enter New Salary:");
                    double newSalary = sc.nextDouble();

                    Employee e = empMap.get(eId);

                    if(e == null) {
                        System.out.println("Employee not found");
                        break;
                    }

                    e.setSalary(newSalary);

                    System.out.println("Salary updated successfully");

                    break;

                case 4:

                    System.out.println("Enter Employee ID:");
                    int deleteId = sc.nextInt();

                    Employee removed = empMap.remove(deleteId);

                    if(removed == null) {
                        System.out.println("Employee not found");
                        break;
                    }

                    System.out.println("Employee deleted successfully");

                    break;

                case 5:
                    System.exit(0);
            }
        }
    }

    public static void displayEmployee(Employee e) {

        System.out.println("\nEmployee ID: " + e.getId());
        System.out.println("Name: " + e.getName());
        System.out.println("Salary: " + e.getSalary());

        System.out.println("\nDepartment:");
        System.out.println("  Name: " + e.getDepartment().getName());
        System.out.println("  Location: " + e.getDepartment().getLocation());
    }
}
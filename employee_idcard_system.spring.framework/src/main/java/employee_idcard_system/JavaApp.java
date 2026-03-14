package employee_idcard_system;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaApp {

    static Map<Integer, Employee> employeeMap = new HashMap<>();

    static int empId = 201;
    static int cardId = 301;

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Add Employee with IDCard");
            System.out.println("2.Search Employee by ID");
            System.out.println("3.Update IDCard Issue Date");
            System.out.println("4.Delete Employee");
            System.out.println("5.Exit");

            System.out.println("Enter Choice:");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Enter Name:");
                    String name = sc.next();

                    System.out.println("Enter Department:");
                    String department = sc.next();

                    System.out.println("Enter Card Number:");
                    String cardNumber = sc.next();

                    System.out.println("Enter Issue Date (yyyy-MM-dd):");
                    String issueDate = sc.next();

                    Employee emp = context.getBean("employee", Employee.class);
                    IDCard card = context.getBean("idCard", IDCard.class);

                    emp.setId(empId++);
                    emp.setName(name);
                    emp.setDepartment(department);

                    card.setId(cardId++);
                    card.setCardNumber(cardNumber);
                    card.setIssueDate(issueDate);

                    emp.setIdCard(card);

                    employeeMap.put(emp.getId(), emp);

                    System.out.println("Employee added successfully");

                    displayEmployee(emp);

                    break;

                case 2:

                    System.out.println("Enter Employee ID:");
                    int id = sc.nextInt();

                    Employee e = employeeMap.get(id);

                    if (e == null) {
                        System.out.println("Employee not found");
                        break;
                    }

                    displayEmployee(e);

                    break;

                case 3:

                    System.out.println("Enter Employee ID:");
                    int empIdUpdate = sc.nextInt();

                    System.out.println("Enter New Issue Date:");
                    String newDate = sc.next();

                    Employee empUpdate = employeeMap.get(empIdUpdate);

                    if (empUpdate == null) {
                        System.out.println("Employee not found");
                        break;
                    }

                    empUpdate.getIdCard().setIssueDate(newDate);

                    System.out.println("IDCard updated successfully");

                    break;

                case 4:

                    System.out.println("Enter Employee ID:");
                    int deleteId = sc.nextInt();

                    Employee removed = employeeMap.remove(deleteId);

                    if (removed == null) {
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

        System.out.println("\nID: " + e.getId());
        System.out.println("Name: " + e.getName());
        System.out.println("Department: " + e.getDepartment());

        System.out.println("ID Card:");
        System.out.println("  Card Number: " + e.getIdCard().getCardNumber());
        System.out.println("  Issue Date: " + e.getIdCard().getIssueDate());
    }
}
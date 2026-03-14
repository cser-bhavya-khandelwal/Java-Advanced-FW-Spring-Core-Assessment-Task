package university_management_system.spring.framework;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaApp {

    static Map<Integer, Department> departmentMap = new HashMap<>();
    static Map<Integer, Course> courseMap = new HashMap<>();
    static Map<Integer, Student> studentMap = new HashMap<>();

    static int deptId = 101;
    static int courseId = 501;
    static int studentId = 901;
    static int profileId = 301;

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Add Department");
            System.out.println("2.Add Course to Department");
            System.out.println("3.Add Student with Profile");
            System.out.println("4.Enroll Student in Course");
            System.out.println("5.Update Student Email");
            System.out.println("6.Delete Student");
            System.out.println("7.Display Student Details");
            System.out.println("8.Exit");

            System.out.println("Enter Choice:");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Enter Department Name:");
                    String deptName = sc.next();

                    Department dept =
                            context.getBean("department", Department.class);

                    dept.setId(deptId++);
                    dept.setName(deptName);
                    dept.setCourses(new ArrayList<>());

                    departmentMap.put(dept.getId(), dept);

                    System.out.println("Department added successfully");
                    System.out.println("Department ID: " + dept.getId());
                    System.out.println("Name: " + dept.getName());

                    break;

                case 2:

                    System.out.println("Enter Department ID:");
                    int dId = sc.nextInt();

                    System.out.println("Enter Course Name:");
                    String courseName = sc.next();

                    System.out.println("Enter Credits:");
                    int credits = sc.nextInt();

                    Department department = departmentMap.get(dId);

                    if (department == null) {
                        System.out.println("Department not found");
                        break;
                    }

                    Course course =
                            context.getBean("course", Course.class);

                    course.setId(courseId++);
                    course.setCourseName(courseName);
                    course.setCredits(credits);

                    courseMap.put(course.getId(), course);

                    department.getCourses().add(course);

                    System.out.println("Course added successfully");
                    System.out.println("Course ID: " + course.getId());
                    System.out.println("Course Name: " + course.getCourseName());
                    System.out.println("Credits: " + course.getCredits());
                    System.out.println("Department: " + department.getName());

                    break;

                case 3:

                    System.out.println("Enter Student Name:");
                    String studentName = sc.next();

                    System.out.println("Enter Email:");
                    String email = sc.next();

                    System.out.println("Enter Phone Number:");
                    long phone = sc.nextLong();

                    System.out.println("Enter Department ID:");
                    int depId = sc.nextInt();

                    Department dep = departmentMap.get(depId);

                    if (dep == null) {
                        System.out.println("Department not found");
                        break;
                    }

                    Student student =
                            context.getBean("student", Student.class);

                    StudentProfile profile =
                            context.getBean("studentProfile", StudentProfile.class);

                    student.setId(studentId++);
                    student.setName(studentName);

                    profile.setId(profileId++);
                    profile.setEmail(email);
                    profile.setPhone(phone);

                    student.setProfile(profile);
                    student.setDepartment(dep);
                    student.setCourses(new HashSet<>());

                    studentMap.put(student.getId(), student);

                    System.out.println("Student added successfully");

                    displayStudent(student);

                    break;

                case 4:

                    System.out.println("Enter Student ID:");
                    int sId = sc.nextInt();

                    System.out.println("Enter Course ID:");
                    int cId = sc.nextInt();

                    Student s = studentMap.get(sId);
                    Course c = courseMap.get(cId);

                    if (s == null || c == null) {
                        System.out.println("Student or Course not found");
                        break;
                    }

                    if (s.getCourses().contains(c)) {
                        System.out.println("Duplicate enrollment not allowed");
                        break;
                    }

                    s.getCourses().add(c);

                    System.out.println("Enrollment successful");

                    break;

                case 5:

                    System.out.println("Enter Student ID:");
                    int stuId = sc.nextInt();

                    System.out.println("Enter New Email:");
                    String newEmail = sc.next();

                    Student st = studentMap.get(stuId);

                    if (st == null) {
                        System.out.println("Student not found");
                        break;
                    }

                    st.getProfile().setEmail(newEmail);

                    System.out.println("Student email updated successfully");

                    break;

                case 6:

                    System.out.println("Enter Student ID:");
                    int deleteId = sc.nextInt();

                    Student removed = studentMap.remove(deleteId);

                    if (removed == null) {
                        System.out.println("Student not found");
                        break;
                    }

                    System.out.println("Student deleted successfully");

                    break;

                case 7:

                    System.out.println("Enter Student ID:");
                    int displayId = sc.nextInt();

                    Student displayStudent = studentMap.get(displayId);

                    if (displayStudent == null) {
                        System.out.println("Student not found");
                        break;
                    }

                    displayStudent(displayStudent);

                    break;

                case 8:
                    System.exit(0);
            }
        }
    }

    public static void displayStudent(Student s) {

        System.out.println("\nStudent ID: " + s.getId());
        System.out.println("Name: " + s.getName());

        System.out.println("\nProfile:");
        System.out.println("  Email: " + s.getProfile().getEmail());
        System.out.println("  Phone: " + s.getProfile().getPhone());

        System.out.println("\nDepartment:");
        System.out.println("  Name: " + s.getDepartment().getName());

        System.out.println("\nCourses Enrolled:");

        for (Course c : s.getCourses()) {
            System.out.println("  " + c.getCourseName() +
                    " (" + c.getCredits() + " Credits)");
        }
    }
}
package student_course_system;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaApp {

    static Map<Integer, Student> studentMap = new HashMap<>();
    static Map<Integer, Course> courseMap = new HashMap<>();

    static int studentId = 701;
    static int courseId = 801;

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n1.Add Student");
            System.out.println("2.Add Course");
            System.out.println("3.Enroll Student in Course");
            System.out.println("4.Drop Course");
            System.out.println("5.Display Student");
            System.out.println("6.Exit");

            System.out.println("Enter Choice:");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.println("Enter Student Name:");
                    String name = sc.next();

                    Student student = context.getBean("student", Student.class);

                    student.setId(studentId++);
                    student.setName(name);
                    student.setCourses(new HashSet<>());

                    studentMap.put(student.getId(), student);

                    System.out.println("Student added successfully");

                    break;

                case 2:

                    System.out.println("Enter Course Name:");
                    String courseName = sc.next();

                    System.out.println("Enter Credits:");
                    int credits = sc.nextInt();

                    Course course = context.getBean("course", Course.class);

                    course.setId(courseId++);
                    course.setCourseName(courseName);
                    course.setCredits(credits);
                    course.setStudents(new HashSet<>());

                    courseMap.put(course.getId(), course);

                    System.out.println("Course added successfully");

                    break;

                case 3:

                    System.out.println("Enter Student ID:");
                    int sId = sc.nextInt();

                    System.out.println("Enter Course ID:");
                    int cId = sc.nextInt();

                    Student s = studentMap.get(sId);
                    Course c = courseMap.get(cId);

                    if(s == null || c == null) {
                        System.out.println("Student or Course not found");
                        break;
                    }

                    if(s.getCourses().contains(c)) {
                        System.out.println("Duplicate enrollment not allowed");
                        break;
                    }

                    s.getCourses().add(c);
                    c.getStudents().add(s);

                    System.out.println("Enrollment successful");

                    break;

                case 4:

                    System.out.println("Enter Student ID:");
                    int stId = sc.nextInt();

                    System.out.println("Enter Course ID:");
                    int crId = sc.nextInt();

                    Student st = studentMap.get(stId);
                    Course cr = courseMap.get(crId);

                    if(st == null || cr == null) {
                        System.out.println("Student or Course not found");
                        break;
                    }

                    st.getCourses().remove(cr);
                    cr.getStudents().remove(st);

                    System.out.println("Course dropped successfully");

                    break;

                case 5:

                    System.out.println("Enter Student ID:");
                    int id = sc.nextInt();

                    Student stu = studentMap.get(id);

                    if(stu == null) {
                        System.out.println("Student not found");
                        break;
                    }

                    displayStudent(stu);

                    break;

                case 6:
                    System.exit(0);
            }
        }
    }

    public static void displayStudent(Student s) {

        System.out.println("\nStudent ID: " + s.getId());
        System.out.println("Name: " + s.getName());

        System.out.println("\nCourses Enrolled:");

        for(Course c : s.getCourses()) {
            System.out.println("  " + c.getCourseName() +
                    " (" + c.getCredits() + " Credits)");
        }
    }
}
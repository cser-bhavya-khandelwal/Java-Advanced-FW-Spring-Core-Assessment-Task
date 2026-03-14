package school_student_system;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaApp {

    static Map<Integer, School> schoolMap = new HashMap<>();

    static int schoolId = 401;
    static int studentId = 101;

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n1.Add School with Students");
            System.out.println("2.Search School by ID");
            System.out.println("3.Add Student to School");
            System.out.println("4.Delete School");
            System.out.println("5.Exit");

            System.out.println("Enter Choice:");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.println("Enter School Name:");
                    String name = sc.next();

                    System.out.println("Enter City:");
                    String city = sc.next();

                    System.out.println("Enter Number of Students:");
                    int count = sc.nextInt();

                    School school = context.getBean("school", School.class);

                    school.setId(schoolId++);
                    school.setName(name);
                    school.setCity(city);

                    List<Student> list = new ArrayList<>();

                    for(int i=0;i<count;i++) {

                        System.out.println("Enter Student Name:");
                        String sname = sc.next();

                        System.out.println("Enter Grade:");
                        int grade = sc.nextInt();

                        Student student = context.getBean("student", Student.class);

                        student.setId(studentId++);
                        student.setName(sname);
                        student.setGrade(grade);

                        list.add(student);
                    }

                    school.setStudents(list);

                    schoolMap.put(school.getId(), school);

                    System.out.println("School added successfully");

                    displaySchool(school);

                    break;

                case 2:

                    System.out.println("Enter School ID:");
                    int id = sc.nextInt();

                    School s = schoolMap.get(id);

                    if(s == null) {
                        System.out.println("School not found");
                        break;
                    }

                    displaySchool(s);

                    break;

                case 3:

                    System.out.println("Enter School ID:");
                    int sid = sc.nextInt();

                    School scObj = schoolMap.get(sid);

                    if(scObj == null) {
                        System.out.println("School not found");
                        break;
                    }

                    System.out.println("Enter Student Name:");
                    String sn = sc.next();

                    System.out.println("Enter Grade:");
                    int g = sc.nextInt();

                    Student st = context.getBean("student", Student.class);

                    st.setId(studentId++);
                    st.setName(sn);
                    st.setGrade(g);

                    scObj.getStudents().add(st);

                    System.out.println("Student added successfully");

                    break;

                case 4:

                    System.out.println("Enter School ID:");
                    int delId = sc.nextInt();

                    School removed = schoolMap.remove(delId);

                    if(removed == null) {
                        System.out.println("School not found");
                        break;
                    }

                    System.out.println("School deleted successfully");

                    break;

                case 5:
                    System.exit(0);
            }
        }
    }

    public static void displaySchool(School s) {

        System.out.println("\nSchool ID: " + s.getId());
        System.out.println("Name: " + s.getName());
        System.out.println("City: " + s.getCity());

        System.out.println("\nStudents:");

        int i=1;
        for(Student st : s.getStudents()) {

            System.out.println("  " + i++ + ". " + st.getName() +
                    " - Grade " + st.getGrade());
        }
    }
}
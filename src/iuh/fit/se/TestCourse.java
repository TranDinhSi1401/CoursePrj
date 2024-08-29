package iuh.fit.se;

import java.util.Scanner;

/*
* @description: a class is used to test class courseList
* @author: Tran Dinh Si
* @version: 1.0
* @created: 28/8/2024
*
* */
public class TestCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseList courses = new CourseList(10);
        initData(courses);

        int choice;
        do {
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("4. Find course by id");
            System.out.println("5. Search code");
            System.out.println("6. Search by department");
            System.out.println("7. Find max credit course");
            System.out.println("8. Find department with most course");
            System.out.println("9. Sort course");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1 -> {
                    System.out.println("Enter course id:");
                    String id = sc.nextLine();
                    System.out.println("Enter course title:");
                    String title = sc.nextLine();
                    System.out.println("Enter course credit:");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter course department:");
                    String department = sc.nextLine();
                    Course c = new Course(id, title, credit, department);
                    if(courses.addCourse(c)) {
                        System.out.println("Course added");
                    }else
                        System.out.println("Course not added");
                }
                case 2 -> {
                    System.out.printf("%15s %30s %10s %10s\n", "id", "title", "credit", "department");
                    Course[] temp = courses.getCourses();
                    for(Course c : temp) {
                        if(c != null)
                            System.out.println(c);
                    }
                }
                case 3 -> {
                    System.out.println("Enter course id:");
                    String id = sc.nextLine();
                    System.out.println("Enter course title:");
                    String title = sc.nextLine();
                    System.out.println("Enter course credit:");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter course department:");
                    String department = sc.nextLine();
                    Course c = new Course(id, title, credit, department);
                    if(courses.removeCourse(c)) {
                        System.out.println("Course removed");
                    }else
                        System.out.println("Course not removed");
                }
                case 4 -> {
                    System.out.println("Enter course id:");
                    String id = sc.nextLine();
                    if(courses.findCourseById(id) != null)
                        System.out.println("Course found");
                }
                case 5 -> {
                    System.out.println("Enter course title:");
                    String title = sc.nextLine();
                    Course[] c = courses.searchCourse(title);
                    for(Course c1 : c) {
                        if(c1 != null)
                            System.out.println(c1);
                    }
                }
                case 6 -> {
                    System.out.println("Enter course department:");
                    String department = sc.nextLine();
                    Course[] c = courses.searchByDepartment(department);
                    for(Course c1 : c) {
                        if(c1 != null)
                            System.out.println(c1);
                    }
                }
                case 7 -> {
                    System.out.println("Find Courses with max credit");
                    Course[] c = courses.findMaxCreditCourses();
                    for(Course c1 : c) {
                        if(c1 != null)
                            System.out.println(c1);
                    }
                }
                case 8 -> {
                    System.out.println("Find department with most course");
                    String departmentMostCourse = courses.findDepartmentWithMostCourses();
                    System.out.println("Department with most course : " + departmentMostCourse);
                }
                case 9 -> {
                    System.out.println("Sort course");
                    courses.sortCourses();
                    Course[] temp = courses.getCourses();
                    System.out.println("CourseList after sort:");
                    for(Course c : temp) {
                        if(c != null)
                            System.out.println(c);
                    }
                }
                default -> System.out.println("Invalid choice");
            }
        }while(choice != 0);

    }

    /*
    * @description: a method to init sample data
    * @author: Tran Dinh Si
    * @created: 28/8/2024
    *
    * */
    public static void initData(CourseList courses) {

        Course course1 = new Course("BIT101", "Java Programming", 3, "FIT1");
        Course course2 = new Course("FIT102", "Web Programming", 3, "FIT");
        Course course3 = new Course("DIT103", "Database Programming", 4, "FIT1");
        Course course4 = new Course("FAT104", "Java Programming", 4, "FIT1");
        Course course5 = new Course("CIT105", "Software Engineering", 3, "FIT");
        Course course6 = new Course("FIT106", "Data Science", 3, "FIT");
        Course course7 = new Course("GIT107", "Machine Learning", 3, "FIT1");
        Course course8 = new Course("EIT108", "Artificial Intelligence", 3, "FIT1");
//        Course course9 = new Course("FIT109", "Computer Vision", 3, "FIT");
//        Course course10 = new Course("FIT110", "Natural Language Processing", 3, "FIT");

        courses.addCourse(course1);
        courses.addCourse(course2);
        courses.addCourse(course3);
        courses.addCourse(course4);
        courses.addCourse(course5);
        courses.addCourse(course6);
        courses.addCourse(course7);
        courses.addCourse(course8);
    }
}

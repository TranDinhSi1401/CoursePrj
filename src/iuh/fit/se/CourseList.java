package iuh.fit.se;
/*
* @description: a class represents courseList
* @author: Tran Dinh Si
* @version: 1.0
* @created: 28/8/2024
* */
import java.util.ArrayList;

public class CourseList {
    private Course[] courses;
    private static int count = 0;

    /*
    *@description: a constructor to create a courseList
    *@param n the length of arr
    *@return a object CourseList
    * */
    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n must be greater than 0");
        this.courses = new Course[n];
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    /*
    * @description: a method to add a Course into arr
    * @param: course The course is added
    * @return: true or false
    * */
    public boolean addCourse(Course c) {
        if (c == null)
            return false;
        if (isExist(c))
            return false;
        if (count == courses.length)
            return false;
        courses[count++] = c;
        return true;
    }

    /*
    * @description: a method to check course have existed
    * @param: course The course need to check
    * @return: true or false
    * */
    public boolean isExist(Course c) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(c.getId()) && courses[i] != null)
                return true;
        }
        return false;
    }

    /*
    * @description: a method to remove a course
    * @param: course The course need to remove
    * @return: true or false
    * */
    public boolean removeCourse(Course course) {
        if(course == null) return false;
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(course.getId())) {
                courses[i] = null;
                return true;
            }
        }
        return false;
    }

    /*
    * @description: a method to find a class with same id
    * @param: id The id of course need to find
    * @return: course which found
    * */
    public Course findCourseById(String id) {
        for(int i = 0; i < count; i++) {
            if(courses[i].getId().equals(id))
                return courses[i];
        }
        return null;
    }

    /*
    * @description: a method to search for course by title
    * @param: title The title of course
    * @return: courseList of course which found
    * */
    public Course[] searchCourse(String title) {
        int n = 0;
        Course[] courseList = new Course[10];
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().equalsIgnoreCase(title)) {
                courseList[n] = courses[i];
                n++;
            }
        }
        return courseList;
    }

    /*
     * @description: a method to search for course by department
     * @param: title The title of course
     * @return: courseList of course which found
     * */
    public Course[] searchByDepartment(String department) {
        int n = 0;
        Course[] courseList = new Course[10];
        for(Course c : courses) {
            if(c != null) {
                if (c.getDepartment().equalsIgnoreCase(department)) {
                    courseList[n] = c;
                    n++;
                }
            }
        }
        return courseList;
    }

    /*
     * @description: a method to find courses with maxCredit
     * @param: nothing
     * @return: courseList of courses with maxCredit
     * */
    public Course[] findMaxCreditCourses() {
        int Max = courses[0].getCredit();
        Course[] courseList = new Course[10];
        int n = 0;
        for(int i = 1; i < count; i++) {
            if(courses[i].getCredit() > Max)
                Max = courses[i].getCredit();
        }
        for(int i = 0; i < count; i++) {
            if(courses[i].getCredit() == Max) {
                courseList[n] = courses[i];
                n++;
            }
        }
        return courseList;
    }

    /*
     * @description: a method to find department with most course
     * @param: nothing
     * @return: department with most course
     * */
    public String findDepartmentWithMostCourses() {
        String mostDepartment = null;
        int max = 0;
        int countMostDepartment;
        for(int i = 0; i < count; i++) {
            countMostDepartment = 0;
            for(int j = 0; j < count; j++) {
                if(courses[i].getDepartment().equals(courses[j].getDepartment())) {
                    countMostDepartment++;
                }
            }
            if(countMostDepartment > max) {
                max = countMostDepartment;
                mostDepartment = courses[i].getDepartment();
            }
        }
        return mostDepartment;
    }

    /*
     * @description: a method to sort courses a - z
     * @param: nothing
     * @return: courses which sorted
     * */
    public Course[] sortCourses() {
        for(int i = 0; i < count; i++) {
            for(int j = i + 1; j < count; j++) {
                if(courses[i].getId().compareTo(courses[j].getId()) > 0) {
                    Course temp = courses[i];
                    courses[i] = courses[j];
                    courses[j] = temp;
                }
            }
        }
        return courses;
    }
}

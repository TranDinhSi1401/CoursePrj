package iuh.fit.se;
/*
* @description: this class represents a course
* @author: Tran Dinh Si
* @version: 1.0
* @created: 26/8/2024
* */
public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    public Course(String id, String title, int credit, String department) {
        //this.id = id;
        setId(id);
        //this.department = department;
        setDepartment(department);
        //this.title = title;
        setTitle(title);
        //this.credit = credit;
        setCredit(credit);
    }

    public Course() {
        this (" ", " ", 1, " ");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.length() < 3)
            throw new IllegalArgumentException("id must have at least 3 characters");
        for(int i = 0; i < id.length(); i++) {
            if(!Character.isLetterOrDigit(id.charAt(i)))
                throw new IllegalArgumentException("id must contain letters and numbers");
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.isEmpty())
            throw new IllegalArgumentException("title must not be empty");
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if(credit <= 0)
            throw new IllegalArgumentException("credit must be greater than 0");
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String toString() {
        return String.format("%15s %30s %10d %10s", id, title, credit, department);
    }
}

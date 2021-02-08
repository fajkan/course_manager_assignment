package se.lexicon.course_manager_assignment.model;

import java.time.LocalDate;
import java.util.Collection;

public class Course extends Student{

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> Students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        //Students = students;
    }

    public Course(int id, String name, String email, String address, int id1, String courseName, LocalDate startDate, int weekDuration, Collection<Student> students) {
        super(id, name, email, address);
        this.id = id1;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        Students = students;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return Students;
    }

    public void setStudents(Collection<Student> students) {
        Students = students;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {


        int id = CourseSequencer.getCourseSequencer();
        courses.add(new Course(id,courseName,startDate,weekDuration));

        return (Course) courses;
    }

    @Override
    public Course findById(int id) {

        for(Course course : courses){
            if(course.getId()==id);
                return course;
        }

        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {

        for(Course course : courses){
            if(course.getCourseName().equalsIgnoreCase(name))
                return courses;
        }

        return null;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {

        for (Course course : courses){
            if(course.getStartDate().isBefore(end))
                return courses;
        }

        return null;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {

        for(Course course : courses){
            if(course.getStartDate().isAfter(start))
                return courses;
        }
        return null;
    }

    @Override
    public Collection<Course> findAll() {

        return courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {

        for(Course course : courses){
        if(course.getId()==studentId)
            return courses;
        }
        return null;
    }

    @Override
    public boolean removeCourse(Course course) {

        boolean courseRemoved = false;
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()){
            Student result = iterator.next();
            if (result.equals(course)){
                iterator.remove();
                courseRemoved = true;
            }
        }

        return courseRemoved;
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}

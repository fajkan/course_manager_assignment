package se.lexicon.course_manager_assignment.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student) {

        StudentView myStudentView = new StudentView(student.getId(),student.getName(),student.getEmail(),student.getAddress());
        return myStudentView;
    }

    @Override
    public CourseView courseToCourseView(Course course) {

        CourseView myCourseView = new CourseView(course.getId(), course.getCourseName(), course.getStartDate(), course.getWeekDuration(), studentsToStudentViews(course.getStudents()));
        return myCourseView;
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {


        List<Course> myCourseViewList = new ArrayList<>();
        for (Course course : courses) {
            if (course.equals(course.getCourseName())) {
                myCourseViewList.add(course);            }
        }
        return coursesToCourseViews(myCourseViewList);

    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {

        List<StudentView> myStudentViewList = new ArrayList<>();
        for (Student student : students) {
            myStudentViewList.add(studentToStudentView(student));
        }
        return myStudentViewList;
    }
}

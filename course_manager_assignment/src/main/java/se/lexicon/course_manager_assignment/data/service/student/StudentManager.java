package se.lexicon.course_manager_assignment.data.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager_assignment.data.dao.CourseDao;
import se.lexicon.course_manager_assignment.data.dao.StudentDao;
import se.lexicon.course_manager_assignment.data.service.converter.Converters;
import se.lexicon.course_manager_assignment.dto.forms.CreateStudentForm;
import se.lexicon.course_manager_assignment.dto.forms.UpdateStudentForm;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentManager implements StudentService {

    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final Converters converters;

    @Autowired
    public StudentManager(StudentDao studentDao, CourseDao courseDao, Converters converters) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.converters = converters;
    }

    @Override
    public StudentView create(CreateStudentForm form) {

        Student createdStudent =studentDao.createStudent(form.getName(),form.getEmail(),form.getAddress());
        StudentView result = converters.studentToStudentView(createdStudent);
        return result;
    }

    @Override
    public StudentView update(UpdateStudentForm form) {

        Student updatedView = studentDao.findById(form.getId());
        updatedView.setName(form.getName());
        updatedView.setAddress(form.getAddress());
        updatedView.setEmail(form.getEmail());
        return converters.studentToStudentView(updatedView);
    }

        //StudentView updatedView = new StudentView(form.getId(), form.getName(),form.getEmail(),form.getAddress());
        //return updatedView;


    @Override
    public StudentView findById(int id) {

        for(Student student : studentDao.findAll()){
            if(student.getId()==id);
            return converters.studentToStudentView(student);
        }

        return null;
    }

    @Override
    public StudentView searchByEmail(String email) {

        for(Student student : studentDao.findAll()){
            if(student.equals(email));
            return converters.studentToStudentView(student);
        }
        return null;
    }

    @Override
    public List<StudentView> searchByName(String name) {

        List<StudentView> myStudentViewList = new ArrayList<>();
        for (Student student : studentDao.findAll()) {
            if(student.equals(name)) {
                myStudentViewList.add(converters.studentToStudentView(student));
            }
        }
        return myStudentViewList;


    }

    @Override
    public List<StudentView> findAll() {

        List<StudentView> myStudentViewFindAll = new ArrayList<>();
        for (Student student : studentDao.findAll()){
            myStudentViewFindAll.add(converters.studentToStudentView(student));
        }
        return myStudentViewFindAll;
    }

    @Override
    public boolean deleteStudent(int id) {

        boolean studentRemoved = false;
        studentDao.removeStudent(studentDao.findById(id));

        return studentRemoved;

    }
}

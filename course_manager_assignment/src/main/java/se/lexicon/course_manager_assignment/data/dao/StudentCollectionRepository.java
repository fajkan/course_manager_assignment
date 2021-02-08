package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;

import java.util.*;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students ;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {

        int id = StudentSequencer.getStudentSequencer();
        students.add(new Student(id,name,email,address));
        return (Student) students;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {

        for(Student student : students){
            if(student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {

        for(Student student : students){
            if(student.getName().equalsIgnoreCase(name));
            {
                return students;
            }
        }
        return null;
    }

    @Override
    public Student findById(int id) {

        for (Student student : students){
            if(student.getId()==id){
                return  student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public boolean removeStudent(Student student) {
        boolean studentRemoved = false;
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            Student result = iterator.next();
            if (result.equals(student)){
                iterator.remove();
                studentRemoved = true;
            }
        }

        return studentRemoved;
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}

package ATB.repositories;

import ATB.model.Students;

import java.util.List;

public interface StudentsRepository {
    void addStudent(Students students);
    void updateStudent(Students students);
    public void removeStudent(int id);
    Students getStudent(int id);
    List<Students> getAllStudents();
}

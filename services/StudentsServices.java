package ATB.services;

import ATB.model.Groups;
import ATB.model.Students;

import java.util.List;

public interface StudentsServices {
    public void addStudent(Students students);
    public void updateStudent(Students students);
    public void removeStudent(int id);
    public Students getStudentId(int id);
    public List<Students> listStudents();
}

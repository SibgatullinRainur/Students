package ATB.services;

import ATB.model.Students;
import ATB.repositories.GroupsRepository;
import ATB.repositories.GroupsRepositoryImpl;
import ATB.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentsServices")
public class StudentsServicesImpl implements StudentsServices {
    private StudentsRepository studentsRepository;
    private GroupsRepository groupsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Autowired
    @Qualifier("groupsReposiory")
    public void setGroupsRepository (GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    @Override
    @Transactional
    public void addStudent(Students students) {
        this.studentsRepository.addStudent(students);
    }

    @Override
    @Transactional
    public void updateStudent(Students students) {
        this.studentsRepository.updateStudent(students);
    }

    @Override
    @Transactional
    public void removeStudent(int id) {
        this.studentsRepository.removeStudent(id);
    }

    @Override
    @Transactional
    public Students getStudentId(int id) {
        return this.studentsRepository.getStudent(id);
    }

    @Override
    @Transactional
    public List<Students> listStudents() {
        //List<Students> listStudents = this.studentsRepository.getAllStudents();
        //for (int i = 0; i < listStudents.size(); i++) {
         //   listStudents.get(i).getIdGroup() = (Integer) groupsRepository.getGroupsName(listStudents.get(i).getIdGroup());
        //}
        return this.studentsRepository.getAllStudents();
    }
}




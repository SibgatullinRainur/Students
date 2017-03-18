package ATB.repositories;

import ATB.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("studentsRepository")
public class StudentsRepositoryImpl implements StudentsRepository {
    private JdbcTemplate jdbcTemplate;
    private GroupsRepository groupsRepository;

    @Autowired
    public StudentsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setGroupsRepository(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    @Override
    public void addStudent(Students students) {
        jdbcTemplate.update("INSERT INTO students (id, familyStudents, nameStudents, nameFatherStudents, Birthdate, idGroup) VALUES(?, ?, ?, ?, ?, ?)",
                students.getId(),
                students.getFamilyStudents(),
                students.getNameStudents(),
                students.getNameFatherStudents(),
                students.getBirthdate(),
                students.getIdGroup()
        );
    }

    @Override
    public void updateStudent(Students students) {
        jdbcTemplate.update("UPDATE students SET id=?,familyStudents=?, nameStudents=?, nameFatherStudents=?, Birthdat=?, idGroup=?)  VALUES(?, ?, ?, ?, ?, ?) WHERE id =?",
                students.getId(),
                students.getFamilyStudents(),
                students.getNameStudents(),
                students.getNameFatherStudents(),
                students.getBirthdate(),
                students.getIdGroup(),
                students.getId()
        );
    }

    @Override
    public void removeStudent(int id) {
        jdbcTemplate.update("DELETE FROM students WHERE id =?",id);
    }

    @Override
    public Students getStudent(int id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM students WHERE Id=?", Students.class, id);
    }

    @Override
    public List<Students> getAllStudents() {
        return this.jdbcTemplate.query("SELECT * FROM students", new RowMapper<Students>() {
            @Override
            public Students mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Students(
                        resultSet.getInt("id"),
                        resultSet.getString("familyStudents"),
                        resultSet.getString("nameStudents"),
                        resultSet.getString("nameFatherStudents"),
                        resultSet.getDate("Birthdate"),
                        resultSet.getInt("idGroup")
                );
            }
        });
    }
}

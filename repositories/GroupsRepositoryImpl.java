package ATB.repositories;

import ATB.model.Groups;
import ATB.model.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository("groupsReposiory")
public class GroupsRepositoryImpl implements GroupsRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GroupsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String getGroupsName(int id) {
        Groups groups = this.jdbcTemplate.queryForObject("SELECT * FROM groups WHERE Id=?", Groups.class, id);
        return groups.getNameGroup();
    }
}

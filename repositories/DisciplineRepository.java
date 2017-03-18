package ATB.repositories;

import ATB.model.Discipline;

import java.util.List;

public interface DisciplineRepository {
   List<Discipline> getAllDisciplines(int id);
}

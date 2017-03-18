package ATB.Controllers;

import ATB.model.Students;
import ATB.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    private StudentsServices studentsServices;

    @Autowired(required = true)
    @Qualifier(value = "studentsServices")
    public void setStudentsServices(StudentsServices studentsServices) {
        this.studentsServices = studentsServices;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String listGroups(Model model){
        model.addAttribute("students", new Students());
        model.addAttribute("listStudents", this.studentsServices.listStudents());

        return "index";
    }

    @RequestMapping(value = "/index/addSt", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute("students") Students students){
        if (students.getId() == 0) {
            this.studentsServices.addStudent(students);
        } else {
            this.studentsServices.updateStudent(students);
        }

        return "redirect:/index";
    }

    @RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id){
        this.studentsServices.removeStudent(id);

        return "redirect:/index";
    }

    @RequestMapping("edit/{id}")
    public String editStudents(@PathVariable("id") int id, Model model){
        model.addAttribute("students", this.studentsServices.getStudentId(id));
        model.addAttribute("listStudents", this.studentsServices.listStudents());

        return "index";
    }
}

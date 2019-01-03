package demo.setup;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    Teacher teacher = new Teacher("Sujata");
    System.out.print(teacher.getName());
    List<Subject> subjects = new ArrayList<>();
    Subject engSubject = new Subject("English", "1");
    Subject hindiSubject = new Subject("Hindi", "2");
    subjects.add(engSubject);
    subjects.add(1, hindiSubject);
    teacher.setSubjects(subjects);
    teacher.getSubjects().forEach(s -> System.out.print(" " + s.getSubName()));
  }
}

package demo.setup;

import java.util.List;

/**
 * @author dinesh.joshi
 *
 */
public class Teacher {

  public Teacher(String name) {
    super();
    this.name = name;
  }

  private String name;
  private List<Subject> subjects;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<Subject> subjects) {
    this.subjects = subjects;
  }

  @Override
  public String toString() {
    return "Teacher [name=" + name + ", subjects=" + subjects + "]";
  }

}

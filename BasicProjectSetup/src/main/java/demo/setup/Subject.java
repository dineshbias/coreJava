package demo.setup;

/**
 * @author dinesh.joshi
 *
 */
public class Subject {

  private String subName;
  private String subId;

  public Subject(String subName, String subId) {
    super();
    this.subName = subName;
    this.subId = subId;
  }

  public String getSubName() {
    return subName;
  }

  public void setSubName(String subName) {
    this.subName = subName;
  }

  public String getSubId() {
    return subId;
  }

  public void setSubId(String subId) {
    this.subId = subId;
  }

  @Override
  public String toString() {
    return "Subject [subName=" + subName + ", subId=" + subId + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((subId == null) ? 0 : subId.hashCode());
    result = prime * result + ((subName == null) ? 0 : subName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Subject other = (Subject) obj;
    if (subId == null) {
      if (other.subId != null) {
        return false;
      }
    } else if (!subId.equals(other.subId)) {
      return false;
    }
    if (subName == null) {
      if (other.subName != null) {
        return false;
      }
    } else if (!subName.equals(other.subName)) {
      return false;
    }
    return true;
  }

}

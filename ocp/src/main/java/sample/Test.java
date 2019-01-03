/**
 * 
 */
package sample;

public class Test {

	// Write logic and Java Constructs you would use to print Name of the
	// student and Total marks obtained by them in decreasing order of the total
	// marks obtained.
	public static void main(String args) {

	}

	class StudentMarks {

		private Student student;
		private Subject subject;

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Subject getSubject() {
			return subject;
		}

		public void setSubject(Subject subject) {
			this.subject = subject;
		}
	}

	class Student {
		String studentName;
		int age;

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	}

	class Subject {
		String subName;
		String totalMarks;

		public String getSubName() {
			return subName;
		}

		public void setSubName(String subName) {
			this.subName = subName;
		}

		public String getTotalMarks() {
			return totalMarks;
		}

		public void setTotalMarks(String totalMarks) {
			this.totalMarks = totalMarks;
		}
	}

}

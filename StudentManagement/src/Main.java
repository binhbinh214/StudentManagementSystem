
import controller.StudentManagement;
import java.util.List;
import model.Student;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        StudentManagement controller = new StudentManagement();
        Menu view = new Menu();

        while (true) {
            view.displayWelcomeMessage();
            int choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    Student student = view.getStudentInput();
                    controller.createStudent(student);
                    break;
                case 2:
                    String query = view.getSearchQuery();
                    List<Student> sortedStudents = controller.findAndSortStudentsByName(query);
                    view.displayStudents(sortedStudents);
                    break;
                case 3:
                    int studentId = view.getStudentIdInput();
                    char action = view.getUpdateOrDeleteAction();
                    if (action == 'U') {
                        Student updatedStudent = view.getStudentInput();
                        controller.updateStudent(studentId, updatedStudent);
                    } else if (action == 'D') {
                        controller.deleteStudent(studentId);
                    }
                    break;
                case 4:
                    List<String> report = controller.generateReport();
                    view.displayReport(report);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }
    }
}

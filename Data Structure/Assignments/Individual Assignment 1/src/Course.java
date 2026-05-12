//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Common contract shared by every course type in the system.
public interface Course {

    String getCourseCode(); // Returns the course's unique code.

    String getCourseTitle(); // Returns the course title.

    int calculateTotalWorkload(); // Returns the total workload hours for one semester.

    String getInstructorName(); // Returns the assigned instructor's name.

    void printCourseDetails(); // Prints the course information in a readable format.

    }

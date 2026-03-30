//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public interface Course {

    String getCourseCode(); //Returns the course's unique code.

    String getCourseTitle(); //Returns the course's title.

    int calculateTotalWorkload(); //Returns the total workload hours for the course per semester.

    String getInstructorName(); //Returns the name of the assigned instructor.

    void printCourseDetails(); //Prints all relevant information about the course.

    }

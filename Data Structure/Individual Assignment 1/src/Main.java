// Demonstrates how the course classes and manager work together.
public class Main  {

    public static void main(String[] args) {
        // Create lecture courses.
        LectureCourse lec1 = new LectureCourse("WIA1002","Data Structure","Bernard",4);
        LectureCourse lec2 = new LectureCourse("GLT1005","Effective Oral Communication","Chee Keat",2);

        // Create lab courses.
        LabCourse lab1 = new LabCourse("WIA1005","Network Technology Foundation", "Jun Onn",2,1);
        LabCourse lab2 = new LabCourse("WIA1003","Computer System Architecture", "Hong Zhang",2,1);

        // Store every course in one manager so they can be processed together.
        CourseManager<Course> cm = new CourseManager<>();

        cm.addCourse(lec1);
        cm.addCourse(lec2);
        cm.addCourse(lab1);
        cm.addCourse(lab2);

        // Show the original order.
        cm.printAllCourses();

        System.out.println();

        // Sort by workload and print again.
        cm.sortCoursesByWorkload();
        cm.printAllCourses();

        System.out.println();

        System.out.println("Course with the highest total workload: ");
        (cm.getCourseWithHighestWorkload()).printCourseDetails();

        System.out.println();


        // Reuse the sorted list and print it once more.
        cm.sortCoursesByWorkload();
        cm.printAllCourses();

        System.out.println();

        // Remove a course by code and print the remaining list.
        cm.removeCourse("WIA1003");
        cm.printAllCourses();

    }
}

import java.util.ArrayList;
import java.util.*;

// Manages a collection of courses and provides common operations on them.
public class CourseManager<T extends Course> {

    private ArrayList<T> courses;

    CourseManager () {
        this.courses = new ArrayList<>();
    }

    // Adds a new course to the collection.
    public void addCourse(T course) {
        courses.add(course);
    }

    // Removes every course that matches the given course code.
    public void removeCourse(String courseCode) {
        courses.removeIf(course -> course.getCourseCode().equals(courseCode));
    }

    // Finds the course with the highest computed workload.
    public T getCourseWithHighestWorkload() {
        if (courses.isEmpty()) {
            return null;
        }
        T theCourse = (courses.getFirst());
        for (int i = 1; i < courses.size(); i++) {
            if((courses.get(i)).calculateTotalWorkload() > theCourse.calculateTotalWorkload()) {
                theCourse = courses.get(i);
            }
        }
        return theCourse;
    }

    // Sorts courses from lowest to highest workload.
    public void sortCoursesByWorkload() {

        courses.sort(Comparator.comparing(Course::calculateTotalWorkload));
    }

    // Prints every course currently stored in the manager.
    public void printAllCourses() {
        for (T course : courses) {
            course.printCourseDetails();
        }
    }

}

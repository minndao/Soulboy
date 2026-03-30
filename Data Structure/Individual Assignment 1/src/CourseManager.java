import java.util.ArrayList;
import java.util.*;

public class CourseManager<T extends Course> {

    public ArrayList<T> courses;

    CourseManager () {
        this.courses = new ArrayList<>();
    }

    public void addCourse(T course) {
        courses.add(course);
    }

    public void removeCourse(String courseCode) {
        for (int i = 0; i < courses.size(); i++) {
            if ((courses.get(i)).getCourseCode().equals(courseCode)) {
                courses.remove(courses.get(i));
            }
        }
    }

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

    public void sortCoursesByWorkLoad() {

        courses.sort(Comparator.comparing(Course::calculateTotalWorkload));
    }

    public void printAllCourses() {
        for (T course : courses) {
            course.printCourseDetails();
        }
    }

}

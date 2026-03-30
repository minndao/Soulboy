public class Main extends CourseManager {

    public static void main(String[] args) {
        LectureCourse lec1 = new LectureCourse("WIA1002","Data Structure","Bernard",4);
        LectureCourse lec2 = new LectureCourse("GLT1005","Effective Oral Communication","Chee Keat",2);

        LabCourse lab1 = new LabCourse("WIA1005","Network Technology Foundation", "Jun Onn",2,1);
        LabCourse lab2 = new LabCourse("WIA1003","Computer System Architecture", "Hong Zhang",2,1);

        CourseManager cm = new CourseManager();

        cm.addCourse(lec1);
        cm.addCourse(lec2);
        cm.addCourse(lab1);
        cm.addCourse(lab2);

        cm.printAllCourses();

        System.out.println();

        cm.sortCoursesByWorkLoad();
        cm.printAllCourses();

        System.out.println();

        cm.sortCoursesByWorkLoad();
        cm.printAllCourses();

        System.out.println();

        cm.removeCourse("WIA1003");
        cm.printAllCourses();

    }
}

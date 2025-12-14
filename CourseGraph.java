import java.util.HashMap;
import java.util.Map;

/**
 * Stores all courses and their prerequisite relationships.
 */
public class CourseGraph {

    private final Map<String, Course> courses;

    public CourseGraph() {
        courses = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
    }

    public Course getCourse(String courseId) {
        return courses.get(courseId);
    }

    public Map<String, Course> getAllCourses() {
        return courses;
    }
}

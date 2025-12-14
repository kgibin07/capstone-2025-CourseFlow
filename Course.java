import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single course with an ID, credit value, and prerequisites.
 */
public class Course {

    private final String courseId;
    private final int credits;
    private final List<String> prerequisites;

    public Course(String courseId, int credits) {
        this.courseId = courseId;
        this.credits = credits;
        this.prerequisites = new ArrayList<>();
    }

    public void addPrerequisite(String prereqId) {
        prerequisites.add(prereqId);
    }

    public String getCourseId() {
        return courseId;
    }

    public int getCredits() {
        return credits;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }
}

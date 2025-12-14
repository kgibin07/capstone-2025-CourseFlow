import java.util.ArrayList;
import java.util.List;

/**
 * Represents a multi-semester academic plan with credit tracking.
 */
public class SemesterPlan {

    private final List<List<String>> semesters;
    private final int creditLimit;

    public SemesterPlan(int creditLimit) {
        this.creditLimit = creditLimit;
        this.semesters = new ArrayList<>();
    }

    public void addSemester(List<String> courses) {
        semesters.add(courses);
    }

    public List<List<String>> getSemesters() {
        return semesters;
    }

    public int getCreditLimit() {
        return creditLimit;
    }
}

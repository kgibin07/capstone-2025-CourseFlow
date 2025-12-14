import java.util.HashSet;
import java.util.Set;

/**
 * Simple test suite for the Scheduler.
 * Uses explicit condition checks instead of Java assertions.
 */
public class Tests {

    public static void main(String[] args) {
        CourseGraph graph = new CourseGraph();

        Course courseA = new Course("A", 3);
        Course courseB = new Course("B", 3);
        courseB.addPrerequisite("A");

        graph.addCourse(courseA);
        graph.addCourse(courseB);

        Scheduler scheduler = new Scheduler();
        SemesterPlan plan = scheduler.generatePlan(graph, new HashSet<>(), 3);

        if (plan.getSemesters().size() != 2) {
            System.out.println("Test failed: Expected 2 semesters.");
            return;
        }

        if (!plan.getSemesters().get(0).contains("A")) {
            System.out.println("Test failed: Course A should be in semester 1.");
            return;
        }

        if (!plan.getSemesters().get(1).contains("B")) {
            System.out.println("Test failed: Course B should be in semester 2.");
            return;
        }

        System.out.println("All Scheduler tests passed successfully.");
    }
}

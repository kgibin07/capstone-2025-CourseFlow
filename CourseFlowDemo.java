import java.util.HashSet;
import java.util.Set;

/**
 * Demo for CourseFlow.
 */
public class CourseFlowDemo {

    public static void main(String[] args) {
        CourseGraph graph = new CourseGraph();

        Course cs101 = new Course("CS101", 4);
        Course cs102 = new Course("CS102", 4);
        Course cs201 = new Course("CS201", 4);

        cs102.addPrerequisite("CS101");
        cs201.addPrerequisite("CS102");

        graph.addCourse(cs101);
        graph.addCourse(cs102);
        graph.addCourse(cs201);

        Set<String> completed = new HashSet<>();

        Scheduler scheduler = new Scheduler();
        SemesterPlan plan = scheduler.generatePlan(graph, completed, 6);

        int semesterNumber = 1;
        for (var semester : plan.getSemesters()) {
            System.out.println("Semester " + semesterNumber + ": " + semester);
            semesterNumber++;
        }
    }
}

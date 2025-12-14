import java.util.*;

/**
 * Core scheduling engine using topological sorting.
 */
public class Scheduler {

    /**
     * Generates a semester-by-semester plan.
     *
     *Complexity: O(V + E)
     */
    public SemesterPlan generatePlan(
            CourseGraph graph,
            Set<String> completedCourses,
            int creditLimit
    ) {

        Map<String, Integer> indegree = new HashMap<>();
        Queue<String> readyQueue = new LinkedList<>();

        for (String id : graph.getAllCourses().keySet()) {
            indegree.put(id, 0);
        }

        for (Course course : graph.getAllCourses().values()) {
            for (String prereq : course.getPrerequisites()) {
                indegree.put(course.getCourseId(), indegree.get(course.getCourseId()) + 1);
            }
        }

        for (String completed : completedCourses) {
            indegree.remove(completed);
        }

        for (String id : indegree.keySet()) {
            if (indegree.get(id) == 0) {
                readyQueue.add(id);
            }
        }

        SemesterPlan plan = new SemesterPlan(creditLimit);

        while (!readyQueue.isEmpty()) {
            int semesterCredits = 0;
            List<String> semester = new ArrayList<>();
            Queue<String> carryOver = new LinkedList<>();

            while (!readyQueue.isEmpty()) {
                String courseId = readyQueue.poll();
                Course course = graph.getCourse(courseId);

                if (semesterCredits + course.getCredits() <= creditLimit) {
                    semester.add(courseId);
                    semesterCredits += course.getCredits();

                    for (Course c : graph.getAllCourses().values()) {
                        if (c.getPrerequisites().contains(courseId)) {
                            indegree.put(c.getCourseId(), indegree.get(c.getCourseId()) - 1);
                            if (indegree.get(c.getCourseId()) == 0) {
                                carryOver.add(c.getCourseId());
                            }
                        }
                    }
                } else {
                    carryOver.add(courseId);
                }
            }

            readyQueue = carryOver;
            plan.addSemester(semester);
        }

        for (int value : indegree.values()) {
            if (value > 0) {
                throw new IllegalStateException("Cycle detected in prerequisite graph.");
            }
        }

        return plan;
    }
}

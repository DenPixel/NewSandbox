package implemica_tasks.task_two;

public class Runner {
    public static void main(String[] args) {
        Data data = new Data("src/main/java/implemica_tasks/task_two/resource/input.txt");
        Solution solution = new Solution(data);
        solution.searchMinWayCosts("src/main/java/implemica_tasks/task_two/resource/output.txt");
    }
}

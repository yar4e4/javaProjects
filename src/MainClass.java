import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.TextStyle;
import java.util.Locale;

class Planner {
    ArrayList<String> tasks;
    DayOfWeek dayOfWeek;

    public Planner() {
        tasks = new ArrayList<>();
        LocalDate date = LocalDate.now();
        dayOfWeek = date.getDayOfWeek();
    }

    void printDate() {
        System.out.println("День недели - " + dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("ru")));
    }

    void taskAdd(String task) {
        tasks.add(task);
    }

    void taskRemove(int task_num) {
        tasks.remove(task_num);
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Задач пока нет.");
        } else {
            System.out.println("Список задач:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        Planner plan = new Planner();
        plan.printDate();
        plan.taskAdd("Написать планнер задач");
        plan.taskAdd("Сходить в гости к Антону");
        plan.taskAdd("Попить чай с котом");
        plan.taskAdd("Дописать программу");
        plan.printTasks();
        

    }
}
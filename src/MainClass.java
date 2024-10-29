import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class Planner {
    ArrayList<String> tasks;
    DayOfWeek dayOfWeek;
    boolean hasTasks() {
        return !tasks.isEmpty();
    }

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

    void taskRemove(int taskNum) {
        if (taskNum >= 0 && taskNum < tasks.size()) {
            tasks.remove(taskNum);
        } else {
            System.out.println("Неверный номер задачи.");
        }
    }

    void changeTask(int taskNum, String newTask) {
        if (taskNum >= 0 && taskNum < tasks.size()) {
            tasks.set(taskNum, newTask);
        } else {
            System.out.println("\nНеверный номер задачи.");
        }
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            
            System.out.println("\nЗадач пока нет.");
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
        Planner planner = new Planner();
        Scanner scanner = new Scanner(System.in);
        planner.printDate();

        while (true) {
            System.out.println("\nВыберите действие:\n");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Изменить задачу");
            System.out.println("4. Показать задачи");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Переход на следующую строку

            switch (choice) {
                case 1:
                    System.out.print("Введите задачу: ");
                    String task = scanner.nextLine();
                    planner.taskAdd(task);
                    break;

                case 2:
                    System.out.print("Введите номер задачи для удаления: ");
                    int taskNum = scanner.nextInt() - 1;
                    planner.taskRemove(taskNum);
                    break;

                case 3:
                    if (planner.hasTasks()) {
                        System.out.print("Введите номер задачи для изменения: ");
                        int taskNumCheck = scanner.nextInt() - 1;
                        scanner.nextLine(); // Переход на следующую строку
                        System.out.print("Введите новое описание задачи: ");
                        String newTask = scanner.nextLine();
                        planner.changeTask(taskNumCheck, newTask);
                    } else {
                        System.out.println("\nНет задач для изменения.");
                    }
                    break;

                case 4:
                    planner.printTasks();
                    break;

                case 5:
                    System.out.println("Выход...");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nНеверный выбор, попробуйте снова.");
            }
        }
    }
}
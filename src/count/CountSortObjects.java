package count;

import java.util.*;

public class CountSortObjects {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Worker(3, "Anna", 1));
        workers.add(new Worker(4, "Nikita", 2));
        workers.add(new Worker(5, "Lera", 9));
        workers.add(new Worker(1, "Ilya", 5));
        workers.add(new Worker(2, "Dima", 8));

        for (Worker worker : countSortWorkerAge(workers)) {
            System.out.println(worker);
        }
    }

    public static Worker[] countSortWorkerAge(ArrayList<Worker> array) {
        int MAX_VALUE = 0;
        Optional<Worker> optionalMax = array.stream().max(Comparator.comparingInt(Worker::getAge));
        if (optionalMax.isPresent()) MAX_VALUE = optionalMax.get().age;

        Worker[] result = new Worker[array.size()];
        int[] counts = new int[MAX_VALUE + 1];

        for (Worker worker : array) {
            counts[worker.age] += 1;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }
        for (Worker worker : array) {
            result[counts[worker.age] - 1] = worker;
            counts[worker.age]--;
        }

        return result;
    }

    static class Worker {
        int id;
        String name;
        int age;

        public Worker(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Worker{" + "id=" + id + ", name='" + name + ", age=" + age + '}';
        }
    }
}

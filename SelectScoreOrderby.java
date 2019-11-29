import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SelectScoreOrderby {
    static class Student implements Comparable<Student> {
        private int index;
        private int score;

        Student(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public String toString() {
            return String.format("%d %d", index, score);
        }

        @Override
        public int compareTo(Student o) {
            if (score != o.score) {
                return score < o.score ? -1 : 1;
            } else {
                return new Integer(index).compareTo(o.index);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                students.add(new Student(scanner.nextInt(), scanner.nextInt()));
            }
            Collections.sort(students);
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
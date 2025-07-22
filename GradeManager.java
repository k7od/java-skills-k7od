        public class GradeManager {
            public static String[] reverseStudentNames(String[] names) {
                String[] reversed = new String[names.length];
                for (int i = 0; i < names.length; i++) {
                    String name = names[i];
                    String rev = "";
                    for (int j = name.length() - 1; j >= 0; j--) {
                        rev += name.charAt(j);
                    }
                    reversed[i] = rev;
                }
                return reversed;
            }

            public static char getLetterGrade(int score) {
                if (score >= 90 && score <= 100) {
                    return 'A';
                } else if (score >= 80 && score <= 89) {
                    return 'B';
                } else if (score >= 70 && score <= 79) {
                    return 'C';
                } else if (score >= 60 && score <= 69) {
                    return 'D';
                } else {
                    return 'F';
                }
            }

            public static String[] findFailingStudents(String[] names, int[] scores) {
                int count = 0;
                // First, count how many students failed
                for (int i = 0; i < scores.length; i++) {
                    if (scores[i] < 60) {
                        count++;
                    }
                }

                String[] failed = new String[count];
                int index = 0;
                for (int i = 0; i < scores.length; i++) {
                    if (scores[i] < 60) {
                        failed[index] = names[i];
                        index++;
                    }
                }

                return failed;
            }
            public static void main(String[] args) {
                String[] students = {"Idris", "Albaraa", "Osama", "Mohammed"};
                int[] scores = {95, 67, 45, 78};

                System.out.println("Reversed student names:");
                String[] reversed = reverseStudentNames(students);
                for (String name : reversed) {
                    System.out.println(name);
                }

                System.out.println("\nLetter Grades:");
                for (int i = 0; i < students.length; i++) {
                    char grade = getLetterGrade(scores[i]);
                    System.out.println(students[i] + ": " + grade);
                }

                System.out.println("\nFailing Students:");
                String[] failed = findFailingStudents(students, scores);
                for (String name : failed) {
                    System.out.println(name);
                }
            }
        }

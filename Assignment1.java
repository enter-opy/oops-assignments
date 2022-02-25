// Write a program to input rollno name and age of 10 students and display the name of the youngest student
import java.util.*;

class Student {
    int rollno;
    String name;
    String phone;
    int age;
    float cgpa;

    Student(int rollno, String name, String phone, int age, float cgpa) {
        this.rollno = rollno;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.cgpa = cgpa;
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rollno;
        String name;
        String phone;
        int age;
        float cgpa;
        Student stud[] = new Student[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the details of " + (i + 1) + "th student");

            System.out.print("Roll no: ");
            rollno = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            name = sc.nextLine();

            System.out.print("Phone: ");
            phone = sc.nextLine();

            System.out.print("Age: ");
            age = sc.nextInt();

            System.out.print("CGPA: ");
            cgpa = sc.nextFloat();

            stud[i] = new Student(rollno, name, phone, age, cgpa);
        }

        float highestCgpa = 0;
        int topper = 0;

        for (int i = 0; i < 10; i++) {
            if (stud[i].cgpa > highestCgpa) {
                highestCgpa = stud[i].cgpa;
                topper = i;
            }
        }

        System.out.println("The student with highest CGPA is " + stud[topper].name);

        for (int i = 0; i < 10; i++) {
            if (stud[i].name.equals("ANU")) {
                System.out.println("Anu's phone number is " + stud[i].phone);
            }
        }

        int youngestAge = 1000, young = 0;

        for (int i = 0; i < 10; i++) {
            if (stud[i].age < youngestAge) {
                youngestAge = stud[i].age;
                young = i;
            }
        }

        System.out.println("The name of the youngest student is " + stud[young].name);
    }
}
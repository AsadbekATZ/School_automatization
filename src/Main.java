import model.*;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        int stepCode = 1000;
        BranchService branchService = new BranchService();
        CourseService courseService = new CourseService();
        GroupService groupService = new GroupService();
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();

        while (stepCode != 0){
            System.out.println("1.Add Branch, 2.View Branch List, 3.Enter Branch, 0.Exit");
            stepCode = scannerInt.nextInt();
            switch (stepCode){
                case 1 -> {
                    System.out.println("Enter Branch Name");
                    String branchName = scannerStr.nextLine();
                    System.out.println("Enter Branch Location");
                    String location = scannerStr.nextLine();
                    Branch branch = new Branch(branchName, location);
                    System.out.println(branchService.add(branch));
                }
                case 2 -> {
                    int cnt = 0;
                    for (Branch branch : BranchService.branches) {
                        if(branch != null){
                            System.out.println("============" + ++cnt + "=============");
                            System.out.println("Branch Name = " + branch.getName());
                            System.out.println("Branch Location = " + branch.location);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Enter Branch Name");
                    String branchName = scannerStr.nextLine();
                    Branch currentBranch = branchService.login(branchName);
                    if(currentBranch == null){
                        System.out.println("There Is No Such Branch!");
                    }else{
                        int stepCode2 = 100;
                        while (stepCode2 != 0){
                            System.out.println("1.Add Course, 2.View This Branch's Courses, 3.Enter Course, 0.Back");
                            stepCode2 = scannerInt.nextInt();
                            switch (stepCode2){
                                case 1 -> {
                                    System.out.println("Enter Course Name");
                                    String courseName = scannerStr.nextLine();
                                    System.out.println("Enter Course Price");
                                    int coursePrice = scannerInt.nextInt();
                                    Course course = new Course(courseName, coursePrice, currentBranch.getId());
                                    System.out.println(courseService.add(course));
                                }
                                case 2 -> {
                                    int cnt2 = 0;
                                    for (Course course : CourseService.courses) {
                                        if(course != null){
                                            System.out.println("============" + ++cnt2 + "=============");
                                            System.out.println("Course Name = " + course.getName());
                                            System.out.println("Course Price = " + course.coursePrice);
                                            System.out.println("Branch of This Course = " + currentBranch.getName());
                                        }
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Enter Course Name");
                                    String courseName = scannerStr.nextLine();
                                    Course currentCourse = courseService.login(courseName);
                                    if(currentCourse == null){
                                        System.out.println("There Is No Such Course In This Branch!");
                                    }else{
                                        int stepCode3 = 100;
                                        while (stepCode3 != 0){
                                            System.out.println("1.Add Group, 2.View This Course's Groups, 3.Enter Group, 0.Back");
                                            stepCode3 = scannerInt.nextInt();
                                            switch (stepCode3){
                                                case 1 -> {
                                                    System.out.println("Enter Group Name");
                                                    String groupName = scannerStr.nextLine();
                                                    System.out.println("Enter Group capacity");
                                                    int capacity = scannerInt.nextInt();
                                                    System.out.println("Enter Group Teacher's Name");
                                                    String groupTeacherName = scannerStr.nextLine();
                                                    int amountOfStudents = 0;
                                                    Group group = new Group(groupName, capacity, groupTeacherName, currentCourse.getId(), amountOfStudents);
                                                    System.out.println(groupService.add(group));
                                                }
                                                case 2 -> {
                                                    int cnt3 = 0;
                                                    for (Group group : GroupService.groups) {
                                                        if(group != null){
                                                            System.out.println("============" + ++cnt3 + "=============");
                                                            System.out.println("Group Name = " + group.getName());
                                                            System.out.println("Group capacity = " + group.capacity);
                                                            System.out.println("Amount of active Stidents in this goroup = " + group.amountOfStudents);
                                                            System.out.println("Group's Teacher = " + group.groupTeacherName);
                                                            System.out.println("Course of This Group = " + currentCourse.getName());
                                                            System.out.println("Branch of This Group = " + currentBranch.getName());
                                                        }
                                                    }
                                                }
                                                case 3 -> {
                                                    System.out.println("Enter Group Name");
                                                    String groupName = scannerStr.nextLine();
                                                    Group currentGroup = groupService.login(groupName);
                                                    if(currentGroup == null){
                                                        System.out.println("There Is No Such Group In This course!");
                                                    }else{
                                                        int stepCode4 = 100;
                                                        while (stepCode4 != 0){
                                                            System.out.println("1.Add Teacher, 2.Add Student, 3.Login As a Teacher, 4.Login As a Student, 0.Back");
                                                            stepCode4 = scannerInt.nextInt();
                                                            switch (stepCode4){
                                                                case 1 -> {
                                                                    System.out.println("Enter Full Name");
                                                                    String teacherName = scannerStr.nextLine();
                                                                    System.out.println("Enter password");
                                                                    String password = scannerStr.nextLine();
                                                                    System.out.println("Enter Years Of Experience(1 year or less = 30% of total income, 2 years = 40%, 3 years = 50%)");
                                                                    int yearsOFxp = scannerInt.nextInt();
                                                                    Teacher teacher = new Teacher(teacherName, password, yearsOFxp, currentBranch.getName(), currentCourse.getName(), currentGroup.getName(), currentGroup.getId());
                                                                    System.out.println(teacherService.add(teacher));
                                                                }
                                                                case 2 -> {
                                                                    System.out.println("Enter Full Name");
                                                                    String studentName = scannerStr.nextLine();
                                                                    System.out.println("Enter password");
                                                                    String password = scannerStr.nextLine();
                                                                    int absence = 0;
                                                                    currentGroup.amountOfStudents++;
                                                                    if(currentGroup.amountOfStudents <= currentGroup.capacity){
                                                                        Student student = new Student(studentName, password, currentGroup.getId(), absence);
                                                                        System.out.println(studentService.add(student));
                                                                        System.out.println("Place available in this group: " + (currentGroup.capacity - currentGroup.amountOfStudents));
                                                                    }
                                                                    else{
                                                                        System.out.println("No Places Available in This Group");
                                                                    }
                                                                }
                                                                case 3 -> {
                                                                    System.out.println("Enter Full Name");
                                                                    String teacherName = scannerStr.nextLine();
                                                                    System.out.println("Enter password");
                                                                    String password = scannerStr.nextLine();
                                                                    Teacher currentTeacher = teacherService.login(teacherName, password);
                                                                    if(currentTeacher == null){
                                                                        System.out.println("Wrong name or password!");
                                                                    }else{
                                                                        int stepCode5 = 100;
                                                                        while(stepCode5 != 0){
                                                                            System.out.println("1.View my Groups, 2.Check my Salary, 3.Mark Absence of a Student, 0.Back");
                                                                            stepCode5 = scannerInt.nextInt();
                                                                            switch (stepCode5){
                                                                                case 1 -> {
                                                                                    int cnt5 = 0;
                                                                                    for (Group group : GroupService.groups) {
                                                                                        if(group != null){
                                                                                            if(group.getId().equals(currentTeacher.groupId)){
                                                                                                System.out.println("============" + ++cnt5 + "=============");
                                                                                                System.out.println("Group Name = " + group.getName());
                                                                                                System.out.println("Group capacity = " + group.capacity);
                                                                                                System.out.println("Amount of Students in this Group = " + group.amountOfStudents);
                                                                                                System.out.println("Course of This Group = " + courseService.getById(group.courseId));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                case 2 -> {
                                                                                    currentTeacher.salary = teacherService.SalaryIdentifier(currentTeacher.yearsOfXP, currentCourse, currentGroup, currentGroup.amountOfStudents);
                                                                                    System.out.println("Your salary is = " + currentTeacher.salary);
                                                                                }
                                                                                case 3 -> {
                                                                                    System.out.println("Enter Student Name");
                                                                                    String studentName = scannerStr.nextLine();
                                                                                    System.out.println("How many lessons of absence?");
                                                                                    int howMany = scannerInt.nextInt();
                                                                                    System.out.println(studentService.markAbsence(studentName, howMany));
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                case 4 -> {
                                                                    System.out.println("Enter Full Name");
                                                                    String studentName = scannerStr.nextLine();
                                                                    System.out.println("Enter password");
                                                                    String password = scannerStr.nextLine();
                                                                    Student currentStudent = studentService.login(studentName, password);
                                                                    if(currentStudent == null){
                                                                        System.out.println("Wrong name or password!");
                                                                    }else{
                                                                        int stepCode6 = 100;
                                                                        while(stepCode6 != 0){
                                                                            System.out.println("1. See my Group and my attendance, 0.Back");
                                                                            stepCode6 = scannerInt.nextInt();
                                                                            switch (stepCode6){
                                                                                case 1 -> {
                                                                                    for (Group group : GroupService.groups) {
                                                                                        if(group != null){
                                                                                            if(group.getId().equals(currentStudent.groupId) && currentStudent.absence < 3){
                                                                                                System.out.println("Group ===== " + group.getName());
                                                                                                System.out.println("Absense = " + currentStudent.absence);
                                                                                            }else{
                                                                                                System.out.println("Youre not in Any Group!");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
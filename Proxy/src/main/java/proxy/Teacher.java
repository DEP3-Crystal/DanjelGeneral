package proxy;

import java.util.Date;

public class Teacher {
    public static void main(String[] args) {
        Student student=new Student();
        student.attendLesson();
        Student studentProxy=new StudentProxy(new Attendance(true,new Date()));
        studentProxy.attendLesson();
    }
}

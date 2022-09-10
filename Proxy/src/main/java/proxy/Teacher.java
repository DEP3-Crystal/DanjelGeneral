package proxy;

import java.util.Date;

public class Teacher {
    public static void main(String[] args) {
        Student student=new Student(new Attendance(false,new Date()));
        student.attendLesson();

//        Student studentProxy=new StudentProxy(new Attendance(true,new Date()));
//        studentProxy.attendLesson();

//        DailySession=new StudentProxy(new Attendance(false,new Date()));
//        dailySession.attendLesson();
    }
}

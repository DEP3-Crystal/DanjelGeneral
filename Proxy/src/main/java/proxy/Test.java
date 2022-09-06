package proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Class <?> a= Class.forName("proxy.Student");
        Constructor[] allConstructors = a.getClass().getDeclaredConstructors();
        for(int i=0;i<allConstructors.length;i++){
            System.out.println(allConstructors[i]);
        }
        Method []allMethod=a.getClass().getDeclaredMethods();
        for (Method method:allMethod){
            System.out.println(method);
        }

        Student student= (Student) a.newInstance();
        Class []methodArgsType=new Class[]{Integer.class};
        Method method=student.getClass().getDeclaredMethod("attendLesson",methodArgsType);
        method.invoke(student,101);

    }


}

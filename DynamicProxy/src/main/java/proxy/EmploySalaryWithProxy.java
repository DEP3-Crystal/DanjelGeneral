package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmploySalaryWithProxy implements InvocationHandler {
    private  Object realSubject=null;
    Object result = null;

    public EmploySalaryWithProxy(Object realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("giveHike")){
          double hike=(double) args[0];
          if(hike<200){
              throw new RuntimeException("hike amount isn't valid");
          }
        }
        result = method.invoke(realSubject, args);
        return result;
    }
}

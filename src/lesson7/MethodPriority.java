package lesson7;

import com.sun.jdi.Method;

public class MethodPriority {
    public Method method;
    public Integer priority;


    public MethodPriority(java.lang.reflect.Method method, int priority) {
    }


    public Integer getPriority() {
        return priority;
    }
}

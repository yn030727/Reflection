import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodClass {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        //1.获取Class对象
        Class stuClass=Class.forName("Student");
        //2.获取所有公有方法
        System.out.println("***************get all public method*******************");//获取公共方法
        Method[] methodArray = stuClass.getMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************get all method*******************");//获取所有方法
        methodArray = stuClass.getDeclaredMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************get public show1()*******************");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        //实例化一个Student对象
        Object obj = stuClass.getConstructor().newInstance();
        m.invoke(obj, "Ning");

        System.out.println("***************get private show4()******************");
        m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//暴力反射解除私有限定
        Object result = m.invoke(obj, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("result=" + result);


    }
}

import java.io.ObjectStreamException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Text {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        //反射的作用：在运行状态时，动态的获取类的各种属性和方法
//        //一个类只有一个Class对象
//
//        //第一种获取Class对象
//        //如果我们都得到学生对象了，还需要反射干嘛?
//        Student stu1=new Student();
//        Class stuClass=stu1.getClass();
//        System.out.println(stuClass.getName());
//
//        //第二种方式获取Class对象
//        //需要导入包，依赖太强
//        Class stuClass2=Student.class;
//        System.out.println(stuClass==stuClass2);


       Class stuClass3 = null;
        //第三种方式获得Class对象
        try {
            //包名. 没有包就直接类名
            stuClass3=Class.forName("Student");
            //获取所有共有字段
            Field[] fs=stuClass3.getFields();
            for(Field f:fs){
                System.out.print(f);
            }
            System.out.println();
            System.out.println( );
            //获取所有字段
            Field[] fs2=stuClass3.getDeclaredFields();
            for(Field f:fs2){
                System.out.println(f);
            }
            System.out.println();
            System.out.println( );
            //获取共有字段并调用(name)
            Field f=stuClass3.getField("name");
            System.out.println(f);//输出no val
            Object obj=stuClass3.getConstructor().newInstance();
            f.set(obj,"Ning");//输出Ning
            Student stu=(Student) obj;
            System.out.println(stu.name);
            System.out.println();
            System.out.println( );
            //获取私有字段并调用
            f=stuClass3.getDeclaredField("phoneNum");
            System.out.println(f);
            f.setAccessible(true);//暴力反射，解除私有限定
            f.set(obj,"18888888888999");
            System.out.println(stu);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

//        //打印的是Student类对应的字节码对象
//        System.out.println(stuClass3);
//        //获取Student类对应的字节码对象clazz1的名字
//        System.out.println(stuClass3.getName());
//        //通过Student类对应的字节码对象，获取Student类的类名
//        System.out.println(stuClass3.getSimpleName());
//        //通过Student类对应的字节码对象，获取Student类对应的包对象
//        System.out.println(stuClass3.getPackage());
//


    }


}

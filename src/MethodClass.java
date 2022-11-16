import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodClass {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        //1.��ȡClass����
        Class stuClass=Class.forName("Student");
        //2.��ȡ���й��з���
        System.out.println("***************get all public method*******************");//��ȡ��������
        Method[] methodArray = stuClass.getMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************get all method*******************");//��ȡ���з���
        methodArray = stuClass.getDeclaredMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************get public show1()*******************");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        //ʵ����һ��Student����
        Object obj = stuClass.getConstructor().newInstance();
        m.invoke(obj, "Ning");

        System.out.println("***************get private show4()******************");
        m = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//����������˽���޶�
        Object result = m.invoke(obj, 20);//��Ҫ����������һ����Ҫ���õĶ��󣨻�ȡ�з��䣩��һ����ʵ��
        System.out.println("result=" + result);


    }
}

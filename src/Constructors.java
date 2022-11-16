import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Constructors {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz=Class.forName("Student");

        //2.��ȡ���й��й��췽��
        System.out.println("**********************���й��й��췽��*********************************");
        Constructor[] conArray = clazz.getConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }
        System.out.println("************���еĹ��췽��(������˽�С��ܱ�����Ĭ�ϡ�����)***************");
        conArray = clazz.getDeclaredConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("*****************��ȡ���С��޲εĹ��췽��*******************************");
        Constructor con = clazz.getConstructor(null);
        //1>����Ϊ���޲εĹ��췽������������һ��null,��дҲ���ԣ�������Ҫ����һ�����������ͣ��м�������
        //2>�����ص�����������޲ι��캯���������
        System.out.println("con = " + con);
        //���ù��췽��,����ʵ��(�޲�)
        Object obj = con.newInstance();

        System.out.println("******************��ȡ˽�й��췽����������*******************************");
        //���õ���Ĭ�ϵ��Ǹ�
        con = clazz.getDeclaredConstructor(String.class);
        System.out.println(con);
        //���ù��췽��
        con.setAccessible(true);//��������(���Ե��������η�)
        obj = con.newInstance("Boy");

    }
}

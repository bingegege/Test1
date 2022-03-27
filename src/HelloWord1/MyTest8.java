package HelloWord1;

/**
 *
 * @author zhenghuan
 * @date 2021/6/30
 */
public class MyTest8 {

    public static void main(String[] args) {
        Plant.say();//通过类名调用静态方法
        Plant p1 = new Plant();//创建对象
        Plant p2 = new Plant();
    }
}

class Plant{
    static String name="静态植物";
    public static void say() {
        System.out.println("植物类");
    }
    static {
        System.out.println("植物类的静态代码被执行加载了");
    }
    {
        System.out.println("植物类的普通代码被加载了");
    }
}

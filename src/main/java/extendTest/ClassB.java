package extendTest;

public class ClassB extends ClassA{
    @Override
    public void methed2(){
        System.out.println("ClassB====methed2");
    }
    @Override
    public void methed3(){
        System.out.println("ClassB====methed3");
    }

    public static void main(String[] args) {
        ClassA b = new ClassB();
        b.methed();
    }

}

package aki.onjava.references.test;

class BaseClass {
    public void print() {
        System.out.println("BaseClass print method");
    }
}

class DerivedClass extends BaseClass {
    // Override print method
    public void print() {
        System.out.println("DerivedClass print method");
    }
}

public class Test1 {
    public static void main(String[] args) {
        DerivedClass derivedClassObject = new DerivedClass();
         derivedClassObject.print();
        BaseClass obj = derivedClassObject;
        obj.print();
    }
}

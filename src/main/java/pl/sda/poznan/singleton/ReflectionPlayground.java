package pl.sda.poznan.singleton;

import pl.sda.poznan.factory.model.Employee;

import java.lang.reflect.Constructor;

public class ReflectionPlayground {
    // jak utworzyć reflecion w klasie
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName( "pl.sda.poznan.factory.model.Employee" );
        //Class.forName- podajemy ściężkę, której klasy cchemy mieć metadane
        Employee employee = (Employee) clazz.newInstance();

        if (employee instanceof Employee) {
            System.out.println( "Objekt jest typu Employee " );
        }

        SingCompanyWriterFactory instance = SingCompanyWriterFactory.getIstance();
        // getDeclaredConstructor pokaże wszystkie użyte konstruktory w klasie
        Constructor<?>[] decklaredConstructors = SingCompanyWriterFactory.class
                .getDeclaredConstructors();
        for (Constructor c : decklaredConstructors) {
            c.setAccessible( true );
        }
        Constructor<?> declaredConstructor = decklaredConstructors[0];
        SingCompanyWriterFactory o = (SingCompanyWriterFactory) declaredConstructor.newInstance ();
        if (instance == o){
            System.out.println("Ten sam objekt");
        } else {
            System.out.println("Nie ten sam objekt");
        }
    }
}

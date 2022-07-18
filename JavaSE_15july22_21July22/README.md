Java SE
------------------------------------------

    Presuming
            are already aware of:
                History
                Evolution
                Characteristics
                Data Types
                Variables
                Control Structures
                Operators
                Arrays

    Objectives
                OOPs
                java.lang   Standard Classes, Wrappr Classes, Exceptions, Multi-Theading
                java.time   Date Time Api
                java.util   Generics, Collections, Scanner, Random, Functional Interfaces, Lambda Expressions, Streams API
                java.io,
                java.nio    IO Streams
                java.sql    JDBC

    Lab Setup
                Eclispe IDE
                JDK 8
                MySQL

    Object Oriented Programming

                Class and Object

                        class is a user defiend data type to represent an entity
                            using Fields to represent the properties
                            and Methods to represent the behaviours

                        object is a varaible of class type.

                Encapsulation

                        is the process of data hiding. 

                        private
                        protected
                        public
                        default

                        setters and getters

                        'static' keyword
                        'this' keyword

                        constructor     is a special method that gets invoked as and when an object is allocated.
                                        is to initialize the valeus to the fields

                                        1. the construtor must have the same name as that of the class
                                        2. the constuctor do not return any value even not void.
                                        3. coinstructors can not be static.

                                        default constructor
                                        paramatrized constructor
                                        copy constructor

                        public class Circle {
                            public static final double PI=3.14; //class variable
                            private double radius; //instacne -variables

                            public Circle(){
                                this.radius=0;
                            }

                            public Circle(double radius){
                                this.radius = radius;
                            }

                            public Circle(Circle c){
                                this.radius = c.radius;
                            }

                            public void setRadius(double radius){
                                this.radius=radius;
                            }

                            public double getRadius(){
                                return this.radius;
                            }

                            public boolean isGreaterThan(Circle c){
                               return this.radius > c.radius;
                            }

                            public static Circle add(Circle c1,Circle c2){
                                Circle c3 = new Cirlce();
                                c3.radius = c1.radius+c2.radius;
                                return c3;
                            }
                        }

                            Circle c1 = new Circle();
                            c1.setRadius(90);
                            Circle c2 = new Circle(190);
                            Circle c3 = new Circle(c1);

                            System.out.println(c2.isGreaterThan(c3));
                            System.out.println(c1.isGreaterThan(c2));

                            Circle c4 = Circle.add(c2,c3);

                            Circle c5 = c1;

                Inheretence
                        defining a new data type from an exiting data type.
                        the existing type is called super type 
                        the newly created type is called sub type

                        Super <----- Sub                            Single

                                    |<---Sub2
                        Super <-----|                               Hyrarichal
                                    |<---Sub3

                        Super <-----Sub1 <----Sub2 <----Sub3 ...    Multi-level

                                    |<-----Sub4
                        Super <-----|                               Hybrid                     
                                    |<-----Sub1 <----Sub2 <----Sub3


                        Super1<-----|
                                    |<----Sub                       Multiple
                        Super2<-----|

                        Java classes do not support multiple inheretence as due to ambiguity issues.

                        Java classes can implement multiple interfaces

                        class 'extends' another class
                        interface 'extends' another interface
                        class 'impolements' an interface

                        constructor chaining is the process of executing all the constructors of
                        all the super classes in order as and when an object is allocated for a class.

                        'this'      used to call a constructor from another constructor of the same class
                        'super'     used to call a super class constructor from the sub class constructor
                        'final'
                                    final local variables
                                    final class variables
                                    final instance variables        those variables will be treated as constants

                                    final classes can not be extended any furhtur, final classes can not ahve any
                                    sub-classes.

                        class Pen {
                            nib;
                            rifle;
                            barrel;

                            void write(Paper paper){
                                //1
                            }
                        }

                        class Marker extends Pen{
                            void write(WhiteBoard wb){
                                //2
                            }                      
                        }

                Polymorphisim

                    Overlaoding is having two or more methods with the same name but different parameters.
                    Overriding is having two or more methods with the same signature

                        class HumanBeing {
                            
                            Energy eat(Apple apple){
                                Energy e = new Energy();
                                wash(apple);
                                Piece[] pieces = cut(apple);
                                for(Piece p : pieces) 
                                    e.accumulate(chewAndSwallow(p));
                                return e;
                            }

                            Energy eat(IceCream ic){
                                Energy e = new Energy();
                                while(!ic.isEmpty())
                                    e.accumualate(lick(ic));
                                return e;
                            }
                        }

                        class Infant extends HumanBeing {
                            Energy eat(Apple apple){
                                Energy e = new Energy();
                                wash(apple);
                                Piece[] pieces = cut(apple);
                                Paste paste = grind(pieces);
                                while(!paste.isEmpty())
                                    e.accumualate(lick(paste));
                                return e;
                            }
                        }

                        'super'     used to call a super class method from the sub class overriden copy.
                        'final'     final methods can not be overriden

                Abstraction

                    'abstract' keyword to declare an abstract method. where an abstract method  has no implementation.

                    abstract method can housed inside either an abstract class or an interface.

                    An abstract class is a class to which we can not allocate an object.

                    An interface is a user defiend data type to facilitate multiple inheretence.

                    abstract class can have 
                            class variables
                            instance variables
                            static methods
                            non-static methods
                            abstract methods

                    interface can have 
                            only final class variables
                            static methods
                            non-static methods
                            abstract methods

    Java.lang

        Object
                Class getClass()
                int hashCode();
                boolean equals(Object obj);
                String toString();
        System
                in      java.io.InputStream     STD-IN      Keyboard
                err     java.io.PrintStream     STD-ERR     VDU
                out     java.io.PrintStream     STD-OUT     VDU

                exit(int)
                gc();
                identityHashCode(Object);
                ...etc
        Math    

        String
        StringBuffer
        StringBuilder
        
            for a given string, display:
                1. character count
                2. alpha count
                3. digits count
                4. word count
                5. sentence count

        Wrapper Classes

    Exception Handling

        Throwable
            |- Error
            |- Exception                <----- CHECKED
                |- RuntimeException     <----- UNCHECKED

        CHECKED Exceptions are to be handled without which compilation won't proceed,
        UNCHECKED Exceptions are tgnored or not checked by the compiler.
    
        CHECKED Exceptions represent abnormal situations that not in the control of the
        application, and all that an application can do when CHECKED exceptiosn occur is to
        go for an alternate flow, and hence we use try...catch .

        where we will try to do something and if not happening we will switch to an alternate
        in the catch.

            try{
                //the code that we wnat to try executing
            }catch(ExceptionType1 expectionObj){
                //alternate implementation in case of a exception.
            }catch(ExceptionType2 expectionObj){
                //alternate implementation in case of a exception.
            }catch(ExceptionType3 expectionObj){
                //alternate implementation in case of a exception.
            }catch(ExceptionType4 expectionObj){
                //alternate implementation in case of a exception.
            }finally{
                //code to be exctued irrespective of an excpeiton occurs or not
            }

            try{
                //the code that we wnat to try executing
            }catch(ExceptionType1 | ExceptionType2 expectionObj | ExceptionType3 expectionObj){
                //alternate implementation in case of a exception.
            }catch(ExceptionType4 expectionObj){
                //alternate implementation in case of a exception.
            }finally{
                //code to be exctued irrespective of an excpeiton occurs or not
            }

            try(//declare closable objects){
                //the code that we wnat to try executing
            }catch(ExceptionType1 | ExceptionType2 expectionObj | ExceptionType3 expectionObj){
                //alternate implementation in case of a exception.
            }catch(ExceptionType4 expectionObj){
                //alternate implementation in case of a exception.
            }finally{
                //code to be exctued irrespective of an excpeiton occurs or not
            }

        UNCHECKED Exceptions can be avoided. We are not expected to handle them, we must avoid them.

            public class EmployeeService {
                public void increaseSalary(Employee emp,double amount){
                    if(emp!=null){
                        emp.setSalary(emp.getSalary()+amount);
                    }
                }
            }

            public class App{
                public static void main(String ...args) {
                    EmployeeService empService = new EmployeeService();
                    Employee emp=null;
                    empService.increaseSalary(emp,9000);
                }
            }

        'throw'         used to raise an exception programatically
        'throws'        used to transfer an exception from a method to its invoking method
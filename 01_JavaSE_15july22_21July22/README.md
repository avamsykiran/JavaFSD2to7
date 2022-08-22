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

    java.time
        LocalDate              .now(),.of(year,month,day)
        LocalDateTime          .now(),.of(year,month,day,hour,minute,second) 
        ZonedDateTime          .now(ZoneId)

        Duration
        Period

        DateTimeFormatter

    java.util
        Scanner

        Collection (i)          add(E),remove(E),iterator(),size(),isEmpty(),contains(E)
            |
            |-List (i)          get(int index),set(int index,E),first(),last() ...etc
            |   represents linear data structure
            |   index based operation are possible
            |   allows duplicate entires and any number of nulls
            |
            |   Vector      growable and thread-safe array
            |   ArrayList   growable and non-thread-safe array
            |   LinkedList   as a doubly linked list
            |
            |-Set (i)
                |-SortedSet (i)
                represents a non-linear data strucuture
                only one null is allowed
                no duplicates are allowed

                HashSet             does not have any order of retrival
                LinkedHashSet       retrives in the entry order
                TreeSet             retrives in the sorted order


        Map (i)
         |-SortedMap (i)

        Collections (c)
        Comnparator (i)
        java.lang.Comparable (i) 

    java.util.function

        offers a long list of functional interfaces

        an interface having one and only one abstract method is called a functional interface.

        functional interface support lambda expressions. And lambda expression support Stream API.

        suppliers               has a method that does nto take args but returns a value
        consumers               has a method that takes arguemnt(S) but does not return
        predicates              has a method that always returns boolean
        other functional

        a lambda expression is a shrot hand implementation of a functional interface

        public MyInterface{
            int operate(int a,int b);
        }

        public class MyInterfaceImpl implements MyInterface{
            public int operate(int a,int b){
                return a-b;
            }
        }

        MyInterface obj1 = new MyInterfaceImpl();

        MyInterface obj2 = new MyInterface(){
            public int operate(int a,int b){
                return a+b;
            }
        }

        MyInterface obj3 = (x,y) -> x*y;

    java.util.stream                STREAMs API

        Stream
                is a flow of data from a collection or array.

                supports functional programming.

            Arrays.stream(array)
            listObj.stream()
            setObj.stream()

            Terminal Operators
                forEach(Consumer)                       execute the given consumer on each element of the stream, and no return
                collect(Collector)                      collects the values in a stream into a collection.
                reduce(BinaryOperator)                  execute the binary operator on each pair of the elements of the stream
                                                        and returns the final reuslt as an 'Optional' Object.
            Intermidate Operatos
                filter(predicate)           returns a new stream that contains only theose values of the old stream that
                                            satisify the predicate.
                map(UnaryOperator)          used to convert each element in the old stream into a different element 
                                            and returns a new stream of those new elements.

                distinct()                  has no args but returns a new stream of all distinct valeus of the old stream.

    Assignment
   
        Define a enum called TxnType having CREDIT and DEBIT as values.
        Define a model called 'Txn' having 
                    txnId:int,desp:String,amount:double,type:TxnType,txnDate:LocalDate as fields
        Create a 'List<Txn> txns' and add 20 to 25 txns in it.
        Display the txns as below:
        
        TxnId       TxnDate     Desp        Credit      Debit
        -----------------------------------------------------------------
        101         01-Jul-22   SALARY      65000
        102         02-Jul-22   RENT                    5000
        103         02-Jul-22   Mobile RC               3000
        -----------------------------------------------------------------
        Totals                              65000       8000
        -----------------------------------------------------------------
        Balance                                         57000

        use streams api to compute the totalCredit and totalDebit

    java.io and java.nio    IOStreams

        java.io
            InputStream
                |-FileInputStream
                |-ObjectInputStream
                |-DataInputStream

            OutputStream
                |-PrintStream
                |-FileOutputStream
                |-ObjectOutputStream
                |-DataOutputStream

            Reader
                |-FileREader
                |-InputStreamReader
                |-BufferedReader

            Writer
                |-PrintWriter
                |-FileWriter

            File
            IOException
            FileNotFoundException
            Serializable

        java.nio
            Path
            Paths
            Files

    Multi-Layer Application

        dao             Data Access Object      Persistence Logic       insert/update/delete/retrive data 
        service                                 Bussiness Logic         computations/validations/ui-dao
        ui              User Interface          Presentation Logic      accpet data/instruction and display data

    Java Database Connectivity

        1. Load A Driver        Optional since JDBC 4.0     
        2. Create a Connection through DriverManager.getConnection(url,uid,pwd)
        3. a) Statement
           b) PreparesStatement
           c) CallableStatement


        
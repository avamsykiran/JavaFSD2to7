Spring Framework

    is a nut shell a variaty of modules each actering one of the java-ee technologies.
    
    Spring Core                 Dependency Injection
    Spring Context              ApplicationContext
    Spring SpEL                 Spring Expression Language support externalized cofnig...
    Spring Boot                 Rapid Application Development
    Spring AOP                  Aspect Oriented Programming
    Spring Data JPA             Auto-implemented jpa based repositories
    Spring Web                  Web MVC and REST api
    Spring Test                 Testing platform
    Spring Security             Authorization and Authentication
    Spring WebFlux              Asynchronous/ responsive web
    Spring Batch                Batch processing
    ....etc.,
    
Spring Core, Spring Context

    these modules offer dependency injection through Inversion of Control.

    a Service is dependent on a Dao.

    public interface TxnDao {
        .......
    }

    public class TxnDaoFileSystemImpl implements TxnDao {
            .....
    }
        
    public class TxnDaoJdbcImpl implements TxnDao {
         .....
    }

    public class TxnDaoJpaImpl implements TxnDao {
         .....
    }

    public interface TxnService {
        .......
    }
        
    public class TxnServiceImpl implements TxnService {

        private TxnDao txnDao;

        public TxnServiceImpl(TxnDao txnDao) throws OperationFailedException {
            this.txnDao=txnDao;
        }

        public void setTxnDao(TxnDao txnDao){
            this.txnDao=txnDao;
        }

        ........
    }

    TxnService txnService = new TxnServiceImpl(new TxnDaoJdbcImpl());
        //dependency injection through constructor - constructor injection

    txnService.setTxnDao(new TxnDaoJpaImpl());
        //dependency injection through setter   - setter injection


    If this job of injecting dependency can be outsourced to a 
    different library or framework ..etc., that is called inversion 
    of control.

    Container       is any class that can create, manage life cycle, 
                    supply objects of other classes required in an application.

    Component       is any class whose objects are being managed by a Container

    Bean            is an object of the Component class that is being managed by a Container
    
    Spring Containers

        BeanFactory (I)             Spring Core
        ApplicationContext  (I)     Spring Context

            ApplicationContext offers variosu advanced feature when comapred to BeanFactory like
                1. Autowiring
                2. Multiple Context Loading
                3. Bean Property Propagation ...etc.,

        ApplicationContext
            | - ClassPathXmlApplicationContext
            | - FileSystemXmlApplicationcontext
            | - AnnotationConfigApplicationContext
            | - AnnotationConfigWebApplicationContext
                    ....etc.,,

    Bean Configuration is about informing the Container how many components we have
    and which Component is dependent on whihc other component.

    Spring Bean Configuration
        Xml Based Config
        Annotation Based Config
        Java Based Config

        Annotation and Java Based Config

            @Configuration
            @ComponentScan("basePackage")
            @PropertySource("proeprtiesFile.properties")
            public class AppBeanConfig{

                @Bean
                public LocalDate today(){
                    return LocalDate.now();
                }

                @Bean
                public Scanner kbin(){
                    return new Scanner(System.in);
                }
            }

            @Component    
                @Service
                @Repository

            @Autowired
                on a field          field Injection         by field
                on a setter         setter injection        by setter
                on a constructor    constructor injection   by constructor

                autowiring by type      a bean is mapped to a field of teh same type.

            @Qualifier("baenName")
            
                autowiring by name      a bean is ammped to a field through bean-name.

            @Value("SpEL")              is uysed to inject values into a String or primitive field
                                        ${property.key}
                                        #{javaExpression}

            @Scope("singleton|prototype|session|request|global-session")    applied on a component class

            Bean Life Cycle Methods
                @PostConstruct
                @PreDestroy

Spring Boot

    is a spring framework module that offers
         AutoConfiguration and Rapid Application Development and Embeded Servers.


    Spring Core                 Bean Cofniguration class is needed, @Configuaration and @ComponentScan
    Spring Context              ApplicationContext has to be created
    Spring SpEL                 application.properties and @ProeprtySource
    
    Spring AOP                  config a bean for AspectJ annotation provider and Aspects and advices
    Spring Data JPA             TransactionManagemtn and Datasource objects
    Spring Web                  Enable WEB MVC, DispatcherServlet, ViewEngines ..etc.,
    Spring Test                 Testing Environemtn and Database mock setup
    Spring Security             Authorization type, Roels and USer credentials ...etc.,

    These configurations are by default provided if tehse modules are used on top of Spring Boot.
    It is also possible to override the default configs if needed.

    And thus eliminates the time spent on configs and config testing and debuggind that enable RAD.


    Spring Boot projects are called Spring starter projects

    1. Spring Tool Suite - Spring Starter Project wizard
    2. Spring Initializer from https://start.spring.io
    3. Spring Boot CLI

    @SpringBootApplication  =
                                @Configuration
                                @ComponentScan("theCurrentPackageAsBasePackage")
                                @PropertySource("classpath:application.properties")

    SpringApplication.run(SpringIocBootDemoApplication.class, args);
        1. Creates an ApplicationContext
        2. Execute all Spring Runners in order if any
        3. Starts the embeded Servers if any
        4. ApplicationContext is destroyed and Application is Terminated.

    
    Spring Runners facilitate usage of ApplicationContext and perform any console based operations before
    an embeded server might start.
        CommandLineRunner       void run(String a[])
        ApplicationRunner       void run(ApplicationArgs arg)

    @Order
    
Spring AOP

    is another spring framework modules to support Aspect Oriented Programming.

    Aspect is said to be an operation that is parellel curcial and indpendent of the actual applciation
    logic.

        Logging
        Auditing
        Transaction Managmeent
        Authentication and Authorization.
        ....etc

    trying to execute a method (aspect) befoe / after the execution of another method (bussiness logic/joint point).

    Join Point      is theat mehtod of an application at which an aspect must execue.

    Point Cut       is an expression that selects a join point for a given aspect.

    Advice          is the one that decide4 when shoudl the aspect meet the join point like
        after
        before
        around
        after return
        after throw
        ...etc

    
    


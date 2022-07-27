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





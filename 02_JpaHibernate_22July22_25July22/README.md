JPA with Hibernate
----------------------------------------------------

                                        OOP                                 RDBMS   
            ----------------------------------------------------------------------------------------------

    EntityDef                   class                                   table
    Entity                      object                                  row/record/tuple
    Property                    field/data member                       col/field/attribute
    Behaviours                  methods                                 n/a

    Geenralization              inheretence                             Joined Table
    (Is A)                      class Employee {                        emps        empid,name,basic
                                    empid                               mgrs        empid,allowence
                                    ename                               cemps       empid,contractDuration
                                    basic
                                }                                       Single Table
                                                                        all_emps    empid,ename,basic,allowence,contractDuration
                                class Manager extends Employee {
                                    allowence
                                }                                       Table Per Class
                                                                          emps        empid,name,basic      
                                class ContractEmployee extends Employee{  mgrs        empid,name,basic,allowence
                                    contractDuration                      cemps       empid,name,basic,contractDuration
                                }

    Assosiation
    (Has A)
        Composition             class Trainee {                         trainees    tid,name,fee,mobile,email,address,city,state
                                    traineeId : Long
                                    name      : String
                                    fee       : Double
                                    address   : Address
                                }

                                class Address {
                                    mobile
                                    email
                                    address
                                    city
                                    state
                                }
        Aggregation
            OneToOne            class BankAccount {                             accs        anum,bank,branch,trid
                                    accNum                                      trainers    trid,fnm,sal
                                    bank
                                    branch
                                    accountHolder : Trainer                     accs        anum,bank,branch
                                }                                               trainers    trid,fnm,sal,acnum

                                class Trainer {
                                    trainerId
                                    fullName
                                    salary
                                    salaryAccount : BankAccount
                                }

            OneToMany           class Course {                                  courses     crid,cnm
            ManyToOne               cid                                         trainees    tid,name,fee,crid
                                    cname
                                    trainees    : Set<Trainee>
                                }

                                class Trainee{
                                    tid
                                    name
                                    fee
                                    course  : Course
                                }
            
            ManyToMany          Movie <--m-to-m---> Artist

                                Movie <--one-to-Many--> Characters <--Many-to-One---> Artist

            ORM - Object Relational Mapping

            JPA - Java Persistence API is a specification of Java for the concept ORM.
            
                    @Entity             class level
                    @Table(name="")     class level

                    @Id                 field level
                    @GeneratedValue     field level

                    @Column             field level
                    @Transiant          field level

                    @Inheretence           class level
                    @DiscriminatorColumn   class level
                    @DiscriminatorValue    class level

                    @OneTOOne           field level
                    @OneTOMany          field level
                    @ManyToOne          field level
                    @JoinColumn         field level

                    @Embedable          class level
                    @Embeded            field level

                    Persistence.createEntityManagerFactory("name of a persistence unit")
                        EntityManagerFactory.createEntityManager()
                                EntityManager::
                                                persist(entity)                     insert
                                                merge(entity)                       update
                                                remove(entity)                      delete
                                                find(id,class)                      retriving an entity by id
                                                createQuery("JPQL query")
                                                    Query
                                                    TypedQuery

            Hibernate
                        is one of the many implementations of JPA

                SessionFactory.createSession()
                    Session::
                                save(entity)
                                merge(entity)
                                delete(entity)
                                get(id,class)
                                load(id,class)
                                createQuery("hql query")
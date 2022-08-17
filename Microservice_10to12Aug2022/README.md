Microservices
----------------------------------------------------------------------------------

    is an eco-system of inter-communicating isolated individual apis.


    Challenges and Design Patterns

        1. Decomposition

                a) Decompoistion by domain
                    profiles            handle the registration of account holders
                    txns                handle create,update,delete and retrival of txn
                    statement           handle the caliculation of the statement.

                b) Decomposition by sub-domain  and bounded-context
                    profiles            handle the registration of account holders
                        AccountHolder
                            Long ahId
                            String fullName
                            String emailId
                            String mobile

                    txns                handle create,update,delete and retrival of txn
                        AccountHolder
                            Long ahId
                            Double currentBalance

                        Txn
                            Long txnId
                            String desp
                            Double amount
                            TxnType type
                            LocalDate txnDate
                            AccountHolder holder

                    statement           handle the caliculation of the statement.
                        AccountHolder
                            Long ahId
                            String fullName
                            String emailId
                            String mobile
                            Double currentBalance

                        Txn
                            Long txnId
                            String desp
                            Double amount
                            TxnType type
                            LocalDate txnDate

                        Statement
                            AccountHolder holder
                            Set<Txn> txns
                            Double totalCredit
                            Double totalDebit
                            Double statementBalance

        2. Databases    Database per Service 

            profiles            txns         statement
            (profileDB)         (txnDB)

        3. Inter-Service Communication      - Discovery Service Design Pattern

            (Eureka Discovery Service)
                discovery
                    ↓↑
                    ------------------------------------------------------------------
                        ↑↓                            ↑↓                            ↑↓
                    profiles    <--FeignClient-->    txns    <--FeignClient-->   statement
                    (profileDB)                     (txnDB)

        4. Multiple Contact Points          - API gatway design Pattern gives single point of contact

                                                                            AngularApp/ReactApp/AndriodApp
                                                                                        ↓↑
            (Eureka Discovery Service)                                         (spring-cloud api-gateway)
                discovery                                                         api-gateway  
                    ↓↑                                                                  ↓↑
                    -----------------------------------------------------------------------
                        ↑↓                            ↑↓                            ↑↓
                    profiles    <--FeignClient-->    txns    <--FeignClient-->   statement
                    (profileDB)                     (txnDB)

        5. Distributed Tracing


                                                                            AngularApp/ReactApp/AndriodApp
                                                                                        ↓↑
            (Eureka Discovery Service)                                         (spring-cloud api-gateway)
                discovery                                                         api-gateway  
                    ↓↑                                                                  ↓↑
                    -----------------------------------------------------------------------
                        ↑↓                            ↑↓                            ↑↓
                    profiles    <--FeignClient-->    txns    <--FeignClient-->   statement
                    (profileDB)                     (txnDB)
                        ↑↓                            ↑↓                            ↑↓
                    -----------------------------------------------------------------------
                    ↓↑
                tracing-service
                  (sipkin)


        6. External Configuration


                                                                            AngularApp/ReactApp/AndriodApp
                                                                                        ↓↑
            (Eureka Discovery Service)                                         (spring-cloud api-gateway)
                discovery                                                         api-gateway  
                    ↓↑                                                                  ↓↑
                    -----------------------------------------------------------------------
                        ↑↓                            ↑↓                            ↑↓
                    profiles    <--FeignClient-->    txns    <--FeignClient-->   statement
                    (profileDB)                     (txnDB)
                        ↑↓                            ↑↓                            ↑↓
                    -----------------------------------------------------------------------
                    ↓↑                                                                   ↓↑
                tracing-service                                                        config-service
                  (sipkin)                                                          (spring cloud config service)
                                                                                                        ||
                                                                                                        ||
                                                                                                        ↓↑
                                                                                                        GitRepo
                                                                                                            discovery.proeprties
                                                                                                            gatway.properties
                                                                                                            profiles.properties
                                                                                                            txns.properties
                                                                                                            statement.properties


    Microservices - BudgetAnalysisSystem - implementation
    ----------------------------------------------------------------------------------

        Step 1: Develop the core services and establish inter-service communication
            in.cts.budgetanalysis : profiles
                dependencies
                    org.springframework.boot:spring-boot-starter-web
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-openfeign
                    mysq1:mysql-connector-java
                    org.springframework.boot:spring-boot-starter-data-jpa
                configuaration
                    spring.application.name=profiles
                    server.port=9100

                    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
                    spring.datasource.username=root
                    spring.datasource.password=root
                    spring.datasource.url=jdbc:mysql://localhost:3306/bapsDB?createDatabaseIfNotExist=true
                    spring.jpa.hibernate.ddl-auto=update

            in.cts.budgetanalysis : txns
                dependencies
                    org.springframework.boot:spring-boot-starter-web
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-openfeign
                    mysq1:mysql-connector-java
                    org.springframework.boot:spring-boot-starter-data-jpa
                configuaration
                    spring.application.name=txns
                    server.port=9200

                    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
                    spring.datasource.username=root
                    spring.datasource.password=root
                    spring.datasource.url=jdbc:mysql://localhost:3306/batxnsDB?createDatabaseIfNotExist=true
                    spring.jpa.hibernate.ddl-auto=update

            in.cts.budgetanalysis : statement
                dependencies
                    org.springframework.boot:spring-boot-starter-web
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-openfeign
                configuaration
                    spring.application.name=statement
                    server.port=9300

         Step 2: Implement Discovery Service Design Pattern and Client Side Load Balancing
            in.cts.budgetanalysis : discovery
                dependencies
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-starter-netflix-eureka-server
                configuaration
                    @EnableEurekaServer    on Application class

                    spring.application.name=discovery
                    server.port=9000

                    eureka.instance.hostname=localhost
                    eureka.client.registerWithEureka=false
                    eureka.client.fetchRegistry=false
                    eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
                    eureka.server.waitTimeInMsWhenSyncEmpty=0

            in.cts.budgetanalysis : profiles
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    ++ org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    ++@EnableDiscoveryClient  on Application class

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.loadbalancer.ribbon.enabled=false

            in.cts.budgetanalysis : txns
               dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    ++ org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    ++@EnableDiscoveryClient  on Application class

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.loadbalancer.ribbon.enabled=false

            in.cts.budgetanalysis : statement
               dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    ++ org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    ++@EnableDiscoveryClient  on Application class

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.loadbalancer.ribbon.enabled=false    

        Step 3: Implement API Gateway Design Pattern
            in.cts.budgetanalysis : gateway
                dependencies
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-starter-api-gateway
                    org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    @EnableDiscoveryClient          on Application class

                    spring.application.name=gateway
                    server.port=9999

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.gateway.discovery.locator.enabled=true
                    spring.cloud.gateway.discovery.locator.lower-case-service-id=true
                    
            in.cts.budgetanalysis : discovery
            in.cts.budgetanalysis : profiles
            in.cts.budgetanalysis : txns
            in.cts.budgetanalysis : statement
                  
        Step 4: Implement Distributed Tracing Design Pattern
              in.cts.budgetanalysis : discovery
              
              in.cts.budgetanalysis : gateway
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*
           
            in.cts.budgetanalysis : profiles
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*

            in.cts.budgetanalysis : txns
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*

            in.cts.budgetanalysis : statement
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*

            tracing-service
                zipkin-server
                    https://search.maven.org/remote_content?g=io.zipkin&a=zipkin-server&v=LATEST&c=exec 
                    
                    java -jar zipkin.jar

        Step 5: Implement Circuit Breaker Design Pattern
            in.cts.budgetanalysis : discovery  
            in.cts.budgetanalysis : gateway
            in.cts.budgetanalysis : profiles
            in.cts.budgetanalysis : txns
                dependencies
                    ++org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j
                
                configuaration
                    resilience4j.circuitbreaker.configs.default.registerHealthIndicator=true
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInClosedState=4
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInHalfOpenState=2
                    resilience4j.circuitbreaker.configs.default.automaticTransitionFromOpenToHalfOpenEnabled=true
                    resilience4j.circuitbreaker.configs.default.waitDurationInOpenState= 20s
                    resilience4j.circuitbreaker.configs.default.failureRateThreshold= 50
                    resilience4j.circuitbreaker.configs.default.eventConsumerBufferSize= 10

            in.cts.budgetanalysis : statement
               dependencies
                    ++org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j
                
                configuaration
                    resilience4j.circuitbreaker.configs.default.registerHealthIndicator=true
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInClosedState=4
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInHalfOpenState=2
                    resilience4j.circuitbreaker.configs.default.automaticTransitionFromOpenToHalfOpenEnabled=true
                    resilience4j.circuitbreaker.configs.default.waitDurationInOpenState= 20s
                    resilience4j.circuitbreaker.configs.default.failureRateThreshold= 50
                    resilience4j.circuitbreaker.configs.default.eventConsumerBufferSize= 10

        Step 6: External Configuaration Design Pattern
            inTheWorkSpace> md bt-props-repo
                //and then create these files in this directory
                    // gateway.properties
                    // profiles.properties
                    // txns.properties
                    // statement.properties
                    // move the content of 'application.properties' of each microservice into these respective files
                    
                inTheWorkSpace> cd bt-props-repo
                inTheWorkSpace\bt-props-repo> git init           
                inTheWorkSpace\bt-props-repo> git add .
                inTheWorkSpace\bt-props-repo> git commit -m "all service properties"
            
            in.cts.budgetanalysis : discovery
            in.cts.budgetanalysis : config
                dependencies
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-config-server
                    org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                
                configuaration  
                    @EnableDiscoveryClient
                    @EnableConfigServer             on Application class

                    spring.application.name=config
                    server.port=9090

                    spring.cloud.config.server.git.uri=file:///local/git/repo/path

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5
            
            in.cts.budgetanalysis : gateway
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=gateway
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/                    
            
            in.cts.budgetanalysis : profiles
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=profiles
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/   

            in.cts.budgetanalysis : txns
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=txns
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/   

            in.cts.budgetanalysis : statement
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=statement
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/   



Telecome Custoemr Portal
    1. Each customer has to register
    2. Every customer can change his subscription plan
    3. Admin has to maintain plans
    4. Admin has to enter bills of the custoemrs in the portal
    5. Custoemr can view and pay his/her bills
    6. customers can report any problem with the network
    7. Admin has to resolve the problem and close the complaint.

plans:
    customer -> change subscription plans
    admin -> maintain plans
registration:
    customer -> register
bills:
    customer -> view and their bills
    admin -> enter bills in portal
complaints:
    customer -> report any problem 
    admin -> resolve problem and close the complaint
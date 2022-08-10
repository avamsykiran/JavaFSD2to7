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
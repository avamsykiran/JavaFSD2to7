Spring Web

    is also a spring framework module that support both MVC Dynamic Web applications
    and REST webservices.

    Model       is data that flows from a View to a controller or vice-versa

    View        is any html/jsp/thymeleaf page that is used as User Interface.

    Controller  has to receive the request from a client
                    to extract data from the request
                    to process the data using the underlying services and repositories
                    to share the result as model with a view

    database <-->  Repos <-Entities-> Services <-Model-> Controllers <-----REQ----- Client <-> endUser 
                                                            |                           ↑
                                                            |                           |
                                                        (model)                         |
                                                            |                           |
                                                            |                           |
                                                            ↓                           |
                                                            VIEWS   -----------RESP---->|


    Repo        short for repository, is any POJO that hosues persistence logic, also known as DAO

    Service     is any POJO that houses the bussienss logic

     View        is a JSP/JSF ..etc.,

    Controller  has to control the flow of data across the applciation right from a request to a response.
                    Servlets used to play the role of a controller.

   


    Struts, Spring Web are the most used frameworks for WEB MVC apps.

    Spring Web follows Single FrontController MVC design patterm..
                                                                                                    (BROWSER)
    database <-->  Repos <-Entities-> Services <-Model-> Controllers <---> FrontController <---REQ-- Client <-> endUser 
                                                                            |                           ↑
                                                                            |                           |
                                                                (viewName/viewName+model)               |
                                                                            |                           |
                                                                            |                           |
                                                                            ↓                           |
                                                                            VIEWS   -----------RESP---->|

    Repo        short for repository, is any POJO marked with '@Reposiutory' 
                that hosues persistence logic, also known as DAO

    Service     is any POJO marked with '@Service',
                that houses the bussienss logic

    View        is a JSP/JSF ..etc.,

    Controller  is any POJO marked with '@Controller',
                to control the flow of data across the applciation 
                a controller class has methods each to handle one or more kinds of requests.
                these methods are called actionHandlers.
                these actionHandler must be invoked by the front-controller on receiving a req.
                the actionHandler methods return either a viewName as String Object or a
                                                    viewName and model as ModelAndView object
                                                    to the frontController

    FrontController is a servlet called 'DisptacherServlet' provided by the Spring Web Module.
                    
        how does a frontController know which controller.actionMethod() has to be called
        for a given request???

            FrontController uses an object of UrlHandlerMapping interface to find out
            the controller name and action method for an incoming request.

            UrlHandlerMapping has the belwo implementations
                1. ControllerClassNameUrlHandlerMapping
                2. BeanNameUrlHandlerMapping
                3. SimpleUrlHandlerMapping

            Spring boot will automatically config a bean of SimpleUrlHandlerMapping.

                @RequestMapping(value="url",method=ReqeustMethod.GET/POST/...)      on the action method
                    
                @GetMapping("url")      @RequestMapping(value="url",method=ReqeustMethod.GET)
                @PostMapping("url")     @RequestMapping(value="url",method=ReqeustMethod.POST)
                ....etc.,
                    
        how does a frontController know which VIEW to pick up for a given viewName???

            FrontController uses an object of ViewResolver interface to find out
            the VIEW for a given viewName.

            ViewResolver has the below implementations
                1. XmlBeanResourceViewResolver
                2. MessageBundleResourceViewResolver
                3. InternalResourceViewResolver

            Spring boot auto-configs a bean of InternalResourceViewResolver

                InternalResourceViewResolver  has two fields prefix and suffix

                VIEW = prefix + viewName + suffix.

                prefix = "/pages/"
                suffix = ".jsp"

                viewName is "emp-list-page"

                View = "/pages/emp-list-page.jsp"

        @Controller
        @RequestMapping
            @GetMapping
            @PostMapping
        @RequestParam
        @ModelAttribute
        @Valid

  
Spring Data JPA

    is another spring framework module that provides dynamic automatic implmentation of
    repositories

        CrudRepository
            | - JpaRepository
                    List<Entity> findAll()
                    Optional<Entity> findById(id)
                    boolean existsById(id)
                    Entity save(entity)
                    void deleteById(id)

Spring Web REST

    rest api is a web service based on http protocol.

    a web service is a 'bussiness logic' hosted centrally to be consumed by
    a varaity of ui apps.

                                                                                                    (Insomnia/Postman)
                                                                                                    (Angular APP)
                                                                                                    (ReactJS APP)
                                                                                                    (Andriod APP)
    database <-->  Repos <-Entities-> Services <-Model-> RestControllers <-> FrontController <---REQ-- Rest-Client <-> endUser 
                                                                            |                           ↑
                                                                            |                           |
                                                                        (model) ----RESP (xml/json)---->|

    REST api standards

        Resourece is Employee then /emps can be the end point

                                                                    Http Status Codes
        OPERATION      EndPoint     Http-Method         onSuccess                       onFailure
                                                                               Client Side        Server Side
        ------------------------------------------------------------------------------------------------------------
        CREATE         /emps        POST                201 - CREATE        400 - BAD REQUEST   500 - INTERNAL SERVER ERROR 
        UPDATE         /emps        PUT                 203 - ACCEPTED      400 - BAD REQUEST   500 - INTERNAL SERVER ERROR
        RETRIVE        /emps        GET                 200 - OK            404 - NOT FOUND     500 - INTERNAL SERVER ERROR
                       /emps/101    GET                 200 - OK            404 - NOT FOUND     500 - INTERNAL SERVER ERROR 
        DELETE         /emps/101    DELETE              202 - NO CONTENT    404 - NOT FOUND     500 - INTERNAL SERVER ERROR


    @RestController     =   @Controller + @ResponseBody (it means that no view, take data directly)
    @PathVariable
    @RequestBody

    ResponseEntity
        response-body and http-status
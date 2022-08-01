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

                InternalResourceViewResolver  has two fields  prefix and suffix

                VIEW = prefix + viewName + suffix.

                prefix = "/pages/"
                suffix = ".jsp"

                viewName is "emp-list-page"

                View = "/pages/emp-list-page.jsp"

  

Angular
--------------------------------------------------------------------------------------------------

    Lab Setup
    -----------------------------

        NodeJS  >14
        Angular CLI >12
        VS Code IDE

    Intro
    -----------------------------
        Angular is a SPA development javascript framework.

        Dynamic Web Applications

            WebServer                                               Browser
                Server side
                executing programes <--------------REQ------
                and View Engine
                                    An html content is
                                    dynamically created 

                Servlets/JSP/       --------HTML content (RESP)--->
                ...etc.,

        Single Page Application
        
            WebServer                                               Browser
                SPA-bundle          <-------------REQ-------
                (index.html+        --entire spa-bundle (RESP)-->   index.html is loaded along with
                JavascriptCode)                                     the javascript code on to the browser

                                                                    the request processing will happen on the
                                                                    client itself, and the dynamic html
                                                                    if any needed is generated on the client
                                                                    and is replaced in the index.html
                                                                    without having to load or unload any page.

            REST api            <--------------------REQ----        javascrpt on the client if needs data
                                -------data.json (RESP)----->       

    What NodeJS for ?
    ------------------------------

        1. Angular is a typescript based framework
        2. No browser understands typescript and hence typescript must be compiled into javascript.

        For an angular project
            1. Compose the code     we use VSCode as IDE
            2. Compile the code     we use babel compiler
            3. Test the code        we use jasmine and karma
            4. Bundle the code      we use webpack
            5. manage dependencies  we use npm (node package manager)

        all these tools like babel,jasmine,karma,webpack,npm are all javascript tools and
        should run on the developer machine not on the client machine. And here
        we need nodejs to facilitate the execution of the above tools.

    Typescript
    ----------------------------------

        Typescript = javascript + typeSafety

        javascript                              typescript

        class Employee {                            class Employee {
            constructor(){                              private empId:number;
                this.empId=0;                           private fullName:string;
                this.fullName="";                       private salary:number;
                this.salary=0;                          private joinDate:Date;
                this.joinDate=new Date();               
                                                        constructor(){
            }                                               this.empId=0;
                                                            this.fullName="";
                                                            this.salary=0;
                                                            this.joinDate=new Date();
                                                        }

            getTA(){                                    getTA():number{
                return this.salary*0.50;                    return this.salary*0.50;
            }                                           }
        }                                           }

    Angular CLI
    ----------------------------------

        is a command line interface (a package of tools) needed to create,manage, test and execute an angular project.

        ng new proj-name

        proj-name\> ng serve --port 8989 -o
        proj-name\> ng build
        proj-name\> ng test


    Angular Archetecture
    ------------------------------------

        an angular proejct is made up of many resources like Modules,Components,Directives,
        Pipes,Services ..etc.,

        each such angular resoure is a typescript class. 
        each class is marked with a decorator to indicate the resource identified by that class.
        each decorator is given a json object containing the configuration details and it is called meta-data.

        Modules

            a module is a logical group of things.
            a javascript / typescript module is diffeent from an angular module.
            in an angualr project we have both kinds of modules.

            a javascript / typescript moduel is a file contining classes or functions to be used in naother file 

            an angular moduel is a collection of angualr resources like Directives,Components,Pipes and Services.

            an angular project can be organized into any number of moduels , but it is compulsory to have
            a top-level module. and all others must fall into this top-level module and such
            top-klevel module is called 'ROOT' module and its sub-modules are called 'FEATURE' module.

            @NgModule({
                declarations:[//hold the lsit of directives,components and pipes that belong here],
                imports:[//hold a list of sub-modules to be imported here],
                exports:[//hold of list of directives,components,pipe that belong here and are allowed to be used outside],
                providers:[//hold the list of services that belong here],
                bootstrap:[//hold the lsit of components that must be instantiated immediatly after loading this module]
            })
            class MyModule{}

            bootstrap property is needed only by the root-module and exports proeprty is never used
            in a root-module.

            ng g module module-name

        Components

            angular allows us to create our own html-tags and this is called extendability.
            each componenet is a user defiend html-tag.

            the selector proeprty is the tag-name.

            component = component.ts + component.html
                        component class + component template

                        component class will hold the data related to the component and behaviours like event handling.
                        template will provide the display content for that tag.

            @Component({
                selector:'',
                templateUrl:''
            })
            class DashboardComponent{}

            ng g component ComponentName --skip-tests
            ng g c ComponentName --skip-tests

            Data Binding
            ---------------------------
                is utilizing the fields of the component class in the component template.

                Interpolation
                    {{angular-expression}}
                
                Two Way Binding
                    is used to accept or load value of a field into a form control.

                    [(ngModel)]="field"

                    ngModel is a directive (user-defiend html-attribute ).

                    ngModel directive can be used only on form controls like input,select,textarea ..etc.,

                    ngModel belongs to FormsModule, FormsModule belongs to '@angular/forms'.

                One Way Binding

                    Attribute Binding
                        the value of a field is assigned to an html attribute, and the attribute is updated 
                        everytime the field changes.
                        
                        [attribute]="field"

                    Style Binding
                        the value of a field is assigned to an css style property

                        [style.cssProperty]="field"

                    Css Class Binding
                        the value of a boolean field is assigned to a css-class name.
                        the css class is applied if the boolena field is true orelse the css-class is not applied.

                        [class.className]="booleanField"

                Event Binding

                    (eventDirective) = "method()"

                    html event attribute            event-directive
                        onclick                         click
                        ondblclick                      dblclick
                        onfocus                         focus
                        onblur                          blur
                        onchange                        change
                        onsubmit                        ngSubmit
                        onmouseover                     mouseover
                        ...etc
                

        Directives

            Components
                user defiend html eleemnts (tags)

            Attribute Directives
                user defiend html attributes
                ngModel,click,dblclick ..etc.,

            Structural Directives
                is an attribute directive that controls the apperence of an element
                *ngIf
                *ngFor

            Custome Directives
                 ng g directive DirectiveName --skip-tests

                @Directive({
                    selector:''
                })
                class HighlighterDirective{}

        Pipes
            is used to transform the value into another just before rendering.

            lowercase
            uppercase
            titlecase
            number
            currency
            date

            ng g pipe PipeName --skip-Tests
            
            @Pipe({
                name:''
            })
            class ConvertToWordsPipe{}

        Services
            is used to hold bussiness logic., like
            validations, caliculations, rest-api communication ...etc.,

            services are injectable into components,directives,pipes and 
            other services.

            ng g service serviceName --skip-tests

            @Injectable({
                providedIn:'root'
            })
            class EmployeeService{}

    Routing
    ---------------------------------------------

        allows us to display a component based on the path in the url.

        RouterModule     from    '@angular/router' file

            Route       {
                            path:'',
                            pathMatch:'full|startsWith',
                            redirectTo:'',
                            component:ComponentName,
                            children:[]
                        }

            Routes      Route[]

            forRoot(routes)

            router-outlet       component

            routerLink          attribute directive to be used only on 'a' tags instead of href
            routerLinkActive    attribute directive that takes a 'css-class' to be applied on the
                                current route.

            Router              service used to navigate programatically.

    RxJS
    -----------------------------------------------------------------

        Reactive Javascript
        'IT IS NOT REACTJS'

        let job = observer => {

            observer.next(val); //emiting values while in the async job.
            observer.error(err); //raise an error
            observer.complete(); //indicate the the job is done or closed.
        };
        
        let ob = new Observable(job);

        ob.subcribe({
            next: val => { //to receive the val emitted},
            error: err => {//handle the err raised},
            complte: () => {//to do soemthing after the job is done}
        });

    HttpClient
    --------------------------------------------------------
        is a built-in service coming from 'HttpClientModule'
        'HttpClientModule' comes form '@angular/commons/http'

        HttpClient
            get(url):Observable
            post(url,reqBodyData):Observable
            put(url,reqBodyData):Observable
            delete(url):Observable
            

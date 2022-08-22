Angular  Pre-Required Skills
------------------------------------------------
    1. HTML 5               
        Typography
        Lists and Tables
        Media / Graphics
        Links and Frames
        Form Elements and Validations
        HTML 5 API
            Web Storage
            Geo-Location

    2. CSS 3
        Types of Style Sheets
            Inline
            Embeded
            External
        Selectors
        CSS-Properties
            Box Modeling
            Text related properties
            Background and color related proeprties
            list and table related properties
            Responsive Design

    3. Bootstrap 5          
        a library of CSS classes and widgets (advanced html element)

    4. Javascript (ES6)     
        Language Basics
        Functions   
            normal fucntions
            function expression
            iife
            arrow functions
            closure
            call back
            optional parameters
        Arrays
        Javascipt standard classes / objects like   String,Math,Date
        BOM and DOM
        OOPs        classes,constructors, polymorphisim 
        ES6 Features
            Tempalte Literals
            Spread Operator
            Rest Operator
            Destructured Assignment.
            Module (ESM)


HTML - Hyper Text Mark Up Language
------------------------------------------------------------------------

    is used to write a document that can be shared across HTTP protocol.

    Hyper Text (Hyper Media) is a collection of plain text, formated text, graphcis and links.
    
    Mark up is a practise used in literature...

        WWW (World wide web) is quite ancient now.

        "This is your first day. Have a blast" said my manager.

        Vizag - the steel city - is my home town.

    The symbols used to mark up are called HTML elements.

    Each html element is made up of a opening tag + content + closing tag.

        <p> This is a para element and para content goes here </p>

    a sample html document

        <!DOCTYPE html>
        <html>
            <head>
                <!-- meta data about the current page -->
            </head>
            <body>
                <!-- the page content -->
            </body>
        </html>
    
    Typography
        h1 to h6        heading elements                        block ele
        p               para                                    block ele
        b,u,i           bold, underlien and italisized          inline ele
        strong,em       symatic elements for bold and italics   inline ele   
        sup,sub                                                 inline ele

        div             container block element
        
        nav,header,section
        footer,article
        main,aside      symatic container block elements
        
        span            inline group element

        kbd, code,
        date, mail,
        address,phone   inline group element

    Lists and Tables
        ul          unordered lists
            type        circle/dot/square
        ol          ordered lists
            type        1/a/i/I/A
        li          list item

    HTML Tables    
        table                   to create a table
                border          attribute takes 1 to 5
                width           attribute takes a value in px/%/em/pt/in/cm
                height          attribute takes a value in px/%/em/pt/in/cm
                cellspacing     attribute takes a valeu in px/%/em/pt/in/cm and controls the spacing between two 
                                cells
                cellpadding     attribute takes a valeu in px/%/em/pt/in/cm and controls the spacing between the 
                                cell border and its content

        caption                 sub-element to give a heading to the table
        thead                   sub-element of table element and holds the header rows
        tfoot                   sub-element of table element and holds the footer rows
        tbody                   sub-element of table element and holds the data rows
        tr                      table row is a sub element representing one row and can be used inside
                                thead / tbody / tfoot / table
        th                      table header cell, a sub-element of tr
        td                      table data cell, a sub-element of tr
                rowspan         attribute of th and td representing the number of rows to be occupied default is 1
                colspan         attribute of th and td representing the number of columns to be occupied default is 1

    HTML Media

        img         inline element that injects an image into the page and is a self-closing element
             src    attribute of img tag to hold the relative or absolute or virtual path 
                    of the image

        audio       inline element to inject an audio
        video       inline element to inject a video
        source      sub-element of audio and video to supply the audio file or video file
                    a single audio or video element can house anynumber of source tags
                    each represeting a different format of audio or video.
            src     attibute of source to hold the relative or absolute or virtual path 
                    of the audio or video file

        iframe      used to embed an external web page into our own web page.
            src     attribute to hold the web address of the webpage you wish to embed.

    HTML Links
        a           anchor tag 
            href    attribute takes the destination path.
            target  attribute takes _self/_blank/iframeName

    HTML Form Elements
        form                is used to group a set of fields that have to be submitted to a server program.
            action          attribute takes the path of the server program to which the data has to be submitted
            method          attribute that takes GET/POST
        
        label               used to carry a text related to a field like field names
            for             attribute takes th id of the input element to which the label is related to.

        input               used to create a form field control that enable inputting data
            type            text
                            file
                            password
                            checkbox
                            radio

                            number
                            range
                            decimal
                            email
                            date
                            datetime-locale
            
            id              attribute is used to give an id to the input element.
            name            attribute is sued to give a field name that is carried along with its value to the server.
            value           attribute takes the initial vbalue of the field

            required        attribute ensures that the field is given a value mandatly
            min             attribute that takes a minimum possible value for type="number/decimal/date"
            max             attribute that takes a maximum possible value for type="number/decimal/date"
            minlength       attribute that takes a minimum length of the value while type="text"
            maxlength       attribute that takes a maximum length of the value while type="text"
            pattern         attribute that takes a reglar expression to validate the value while type="text"

        textarea            used to accpet multi line text
        
        select              used to create a drop-down or a list box
            multiple        attribute makes the drop-down into a list enabling multiple option selection
         option             is a sub-element of select used to provide the options
            value           attribute of option tag that takes the value to be submitted if this option is selected

        button              used to create a push button
            type            submit      (defualt)
                            reset
                            button

    HTML Layouts and sematic elements

        <header>    - Defines a header for a document or a section
        <nav>       - Defines a set of navigation links
        <section>   - Defines a section in a document
        <article>   - Defines an independent, self-contained content
        <aside>     - Defines content aside from the content (like a sidebar)
        <footer>    - Defines a footer for a document or a section
        <details>   - Defines additional details that the user can open and close on demand
        <summary>   - Defines a heading for the <details> element
        <figure>    - Defines a self-contained content, like illustrations, diagrams, photos, code listings..etc
        <figcaption>- Defines a caption for a <figure> element.
        <time>	    - Defines a date/time


    HTML entities

        Result	        Description	            Entity Name	    Entity Number
        =============================================================================
        non-breaking    space	                &nbsp;	        &#160;
        <	            less than	            &lt;	        &#60;
        >	            greater than	        &gt;	        &#62;
        &	            ampersand	            &amp;	        &#38;
        "	            double quotation mark	&quot;      	&#34;
        '	            single quotation mark 	&apos;      	&#39;
        ¢	            cent	                &cent;	        &#162;
        £	            pound	                &pound;	        &#163;
        ¥	            yen	                    &yen;	        &#165;
        €	            euro	                &euro;	        &#8364;
        ©	            copyright	            &copy;	        &#169;
        ®	            registered trademark	&reg;	        &#174;
    
CSS 3 
-------------------------------------------------------------------------------------
    CSS 3 - Intro
    -----------------------------------

        Cascading Style Sheet

        purpose is to provide styling to an html document.

        + CSS offers common uniform properties unlike html
        + CSS can provide styling across grouped elements.
        + CSS can isolate styling from content. It adds to maintainability.
        
        Inline Style Sheet

            it is applied using 'style' attribute.

            <tagName style="css-property:value;css-property:value;">
                content
            </tagName>

        Embeded Style Sheet

            it is applied using a tag called <style></style>, style elements
            is a sub-element of <head></head>

            <head>
                <style>
                    selector {
                        css-property:value;
                        css-property:value;
                    }
                </style>
            </head>

            selector is a string that qualfies the elements to be applied with the style.

            1. Tag Name
                    each tag name itself is a selector.
                    
                    tagName{
                        css-property:value;
                    }

            2. Attribute
                    attribute selector groups elements having the mentioned attribute.
                    
                    [attributeName]{
                        css-property:value;
                    }
                    
                    [attributeName=""]{
                        css-property:value;
                    }

            3. Class

                    is any usr defiend string. that should start with dot(.)
                    to apply the class on a element the element class attribute 
                    should be assigned with the class name.

                    .className{
                        css-property:value;
                    }

                    <tagName class="className">
                    </tagName>

            4. Id
                    if a style swhould be applied to an elemnt hving 
                    a specific id, then id selector is sued.

                    #id{
                        css-property:value;
                    }

            5. Psuedo


        External Style Sheet

            style is defiend in a seperate file with extension .css
            and that cna be linked to any number of html pages using
                
                <link href="fileName.css" rel="stylesheet" />


    CSS - unit of measure
    ------------------------------------

        absolute		(irrespective of screen size)
            in
            mm
            cm
            pt		1 in = 72 pt
            pc		1 in = 6  pc   1 pc = 12 pt
        
        relative 	(to screen size)
        
            px
            
            %
            
            em			relative the font-size
                        1 em = complete font-size
                                            
                        font-size: 12pt;
                        width: 8em;	8*12pt = 96pt;
                        
            vh			1% of viewport height
            vw			1% of viewport width
            vmin		min of vh or vw


    CSS Box Model Properties
    -----------------------------------
        margin
        margin-top
        margin-bottom
        margin-left
        margin-right

        border              border-size border-style border-color
        border-top
        border-bottom
        border-left
        border-right

        padding             space between the content and the elemnt border
        padding-top
        padding-bottom
        padding-left
        padding-right

        border-radius       radius of the corners of the element
        border-top-left-radius
        border-top-right-radius
        border-bottom-left-radius
        border-bottom-right-radius

        width
        height
        min-width
        min-height
        max-width
        max-height

        display             inline/block/inline-block

        position            relative / absolute

        top
        left
        bottom
        right
        z-index

    CSS background color and image related properties
    ----------------------------------------------
        background-color
        color
        background-image
        background-repeat       no-repeat/repeat/repeat-x/repeat-y
        background-position
        background-attachment    fixed/scroll
              
    CSS font related properties
    -----------------------------------
        font-family
        font-size
        font-variant		normal or small-caps
        font-weight			bold or bolder or boldest 
                            or any number like 300,400,500..etc
        font-style			italic or oblique
        
    CSS Text related Proeprties
    -----------------------------------
        color
        direction
        letter-spacing
        word-spacing
        text-align
        text-indent
        text-decoration		none | underline | line-through | overline
        
    table related css prperties
    ------------------------------------
        border-collapse			collapse or seperate
        border-spacing
        caption-side			top left right bottom
        
    CSS list related properties
    ----------------------------------

        list-style-type			disc	circle	square	none	for ul
                                decimal							for ol
                                decimal-leading-zero	
                                lower-alpha
                                upper-alpha
                                lower-roman
                                upper-roman
        list-style-position		outside or inside
        list-style-image:		url('imgs/note.png')
        marker-offset
        
  
    controlling scroll bars
    ------------------------------------
        
        overflow
                    visible
                    scroll
                    auto
                    hidden
                
    CSS Operators
    -------------------------------------
        s1		applies to elements that have s1 as tag name
        .s1		applies to elements that have s1 as class
        #s1		applies to elements that have s1 as id

        s1,s2	applies to elements that match both selectors
        s1 s2	applies to all elements that match s2 and are inside s1
        s1>s2	applies to all elements that match s2 whose parent is s1
        s1+s2	applies to all elements that match s2 and are immediately after s1
        s1~s2	applies to every element that match s2 and is preceded by s1

                        applies to all elements that have
                        ------------------------------------
        [s1]			 s1 as attribute
        [s1='v1']		 s1 attrib with v1 value
        [s1~='v1']		 s1 attrib value containes word v1
        [s1*='v1']		 s1 attrib value containes word v1
        [s1!='v1']		 s1 attrib value not equal to v1
        [s1^='v1']		 s1 attrib value starts with the word v1
        [s1$='v1']		 s1 attrib value ends with the word v1

        Psuedo selectors
        ----------------------------------------------------------------------------
        input:enabled	Selects every enabled <input> element
        p:first-child	Selects every <p> element that is the first child 
                        of its parent
        p::first-letter	Selects the first letter of every <p> element
        p::first-line	Selects the first line of every <p> element
        p:first-of-type	Selects every <p> element that is the first <p> 
                        element of its parent
        input:focus		Selects the input element which has focus
        a:hover			Selects links on mouse over
        input:in-range	Selects input elements with a value within a specified range

        input:indeterminate		
                        Selects input elements that are in an indeterminate state

        input:invalid	Selects all input elements with an invalid value
        input:optional	Selects input elements with no "required" attribute

        p:last-child	Selects every <p> element that is the last child of its parent
        p:last-of-type	Selects every <p> element that is the last <p> element of its parent

        a:link			Selects all unvisited links
        :not(p)			Selects every element that is not a <p> element
        p:nth-child(2)	Selects every <p> element that is the second child of its parent
        p:nth-last-child(2)	
                        Selects every <p> element that is the second child of its parent, 
                        counting from the last child

        p:nth-last-of-type(2)	
                        Selects every <p> element that is the second <p> element of its parent, 
                        counting from the last child
        p:nth-of-type(2)	
                        Selects every <p> element that is the second <p> element of its parent
                        
HTML & CSS Assignment
---------------------------------------------------------------------------

    Digital resume:
        Banner Section
                Photo
                Name
                Contact details
        Skill Set
        Technical Qualifications
        Academic Qualification
        Experience And Recent Projects
        Achivments And Publications
        Personal Details

JavaScript (ES6)
---------------------------------------------------------------------------

    Javascript Basics

            is a scripting language that can execute its scripts
            both on a browser and in a stand alone mode too.

            we need a javascript runtime to execute the script
            without a browser. And NodeJS is one such runtime.

            1. javascript inherits it syntx from c and cpp,hence case sensitive
            2. is a dynamically typed language
                a. variables neewd not be declared
                b. even if we declare using var/let/const keywords, we dont specfiy the datatype
                c. the type of a variable is decided after it is assigned a value
                d. a variable can hold data of different types.
                
                integer,floats,strings,null,array,function,undefined

        Datatypes
        Variables and scopes (let,var), operators
        Control Structures
        Program Flows
        String, Math, Date
        
    Javascript OOPs
    Javascript Functions
        Arrow Functions
        Memeber Functions and this keyword
        call and apply
        call backs and closures

    Javascript Arrays
        1. let arr = [];
        2. let arr = new Array();

        3. arrays are not homoginous
        4. arrays are not fixed in size

        Array properties
            arr.length

        Array functions
            arr.push(ele);
            arr.pop();
            arr.concat(anotherArr);
            arr.splice(startIndex,deleteCount);

        Array Prototype Functions
            
            arr.forEach(ele => {}); 
                //will execute the given callback function on each and every ele of the array
            
            arr.sort((ele1,ele2) => { return -1 if ele1<ele2 or return 1 if ele1>ele2 else return 0 })
                //will sort the array and uses the given callback function to compare.
                //and the sort function returns the sorted array.

            arr.map(ele => { write code to transform ele to anuthing else and return it })
                //the map function will execute the givne callback on each ele
                //of the array and returns a new array containing the transformed values.

                let arr = [1,2,3,4,5];
                let arr2 = arr.map( ele => ele*ele);

                arr2 will be [1,4,9,16,25]

            arr.reduce((ele1,ele2) => { return any binary output of ele1 and ele2 })
                //the reduce function will execute the passed binary operation on
                //first two eles of the array, and then that result paired with third ele
                //of the array is again passed to the binary operation and son on...
                //until no more eles left and final reduced value is returned.

                let arr = [1,2,3,4,5];
                let sum = (n1,n2) => n1+n2;

                arr.reduce(sum); 
                    //is as smae as 
                    // sum(sum(sum(sum(arr[0],arr[1]),arr[2]),arr[3]),arr[4])
                    // which is 15

            

    ES6 Enhancements
        Modules
        Template Literals
        Arrow Functions
        Destructuring
        Spread and Rest operators
    
    Javascript Asynchronous Programming
        setInterval
        clearInterval
        setTimeout
        clearTimeout

        async, await and Promise

            a Promise is a class whose object accepts a job-function.
            a job-function accepts two callbacks resolve and resposne and
                excutes a task asynchronously. it invokes resilve incase of
                successful completion of the job and invoke reject incase of error.

            let p = new Promise( 
                (resolve,reject) => {
                    ....async code will go
                        if done call resolve
                        if err call reject
                }
            );

            p.then(
                () => { to respond if job done},
                () => { to respond if job got error}
            );


            define a class that takes a 'count' as a field in its constructor,
            it has to offer a function generateRandomNumbers which returns a promise.
            the generateRandomNumbers function shall generate 'count' number of random
            number using Math.random. the random number must be of the range 0 to 100.
            These numbers must be printed asynchronously and the promise shall emit the
            sum of the random number after resolving and shall reject with an error if the
            count is negative...


    an assignment
    --------------------
    
        let books = [
            {bcode:1,title:'Let Us C',price:567.0,dateOfPublication:new Date('2020-01-01')},
            {bcode:2,title:'Let Us C++',price:1567.0,dateOfPublication:new Date('2020-01-11')},
            {bcode:3,title:'Java Complete Reference',price:2567.0,dateOfPublication:new Date('2020-03-01')}
        ]; //bcode,title,price,dateOfPublication

        const service = {
            addBook: book => {
                books.push(book);
            },
            modifyBook : book => {
                let index = books.findIndex(b => b.bcode==book.bcode);
                if(index>-1){
                    books[index]=book;
                }else{
                    throw new Error("No Such Book Found");
                }
            },
            deleteBookById: id => {
                let index = books.findIndex(b => b.bcode==id);
                if(index>-1){
                    books.splice(index,1);
                }else{
                    throw new Error("No Such Book Found");
                }
            },
            getAllBooks : () => {
                return [...books];
            },
            getBookById : id => {
                let book =  books.find(b => b.bcode==id);
                if(!book){
                    throw new Error("No Such Book Found");
                }
                return {...book};
            }
        };

    Javascript BOM & DOM

        Browser Object Model
            window
                navigator
                    appName
                    appCodeName
                history
                    back()
                    forward()
                location
                    href
                    hostname
                    protocol
                    assign(url)
                document

                alert()
                prompt()
                confirm()
                open()
                close()

        Document Object Model
            document

                elements
                forms

                createElement()
                removeElement()
                replace(oldEle,newEle)
                append()
                prepand()
                getElementById(id)
                getElementsByName(name)
                querySelector("css-selector")

    ES Modules
    -------------------------------------

        requirejs modules
        commonjs modules

        esm - ecma script modules
         a module is a single js file.
         export 
         import

    NodeJS project
    -----------------------------
        npm init -y     //to initilize the current folder into a node project.

        package.json    //is the build config file like pom.xml in mavne/build.gradle in gralde

        npm install     //used to install all the dependencies listed in package.json

        npm install dependency-name --save      //installs the dependency and records in package.json
        npm install dependency-name --dev-save  //installs the dependency and records in package.json as 
                                                //development time dependency
TypeScript
--------------------------------------------------------------------------

    is a Microsoft developed scripting language, and is developed
    as an extension to javascript.

    typescript = javascript + datatypes;

    typescript is not understood by any browser nor any javascript runtime.

    have to compile (transpell) typescript to javascript before execution.

    tsc -   typescript compiler

    tsconfig.json   - typescript compiler configuaration

    syntax
    --------------
        let varName : type;

        class ClassName {
            private privateField : number;
            publicField : string;

            constructor(x:number,y:string){
                this.privateField=x;
                this.publicField=y;
            }

            memberFunction1() : void {
                //do something here.
            }

            memberFunction2() : number {
                let n : number=0;
                //do something here.
                return n;
            }
        }

        interface Shape {
            angles : number[];
            sides : number[];
            
            area() : number;
            perimeter() : number;
        }

HTML 5 Javascript API
---------------------------------------------------------------------------
        GeoLocation
        Web Storage
            localStorage
            sessionStorage

Bootstrap
---------------------------------------------------------------------------

    is a css library that provides responsive web design.

    Bootstrap was developed by Mark Otto and Jacob Thornton at Twitter, 
    and released as an open source product in August 2011 on GitHub.

    Download from : http://getbootstrap.com/

    CDN:

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   
    Look Before You Leep
    ----------------------------

        1. html 5 doctype is a must for Bootstrap 
        2. use lang attributre for html element.
        3. also do set the char set
        4. bootstrap is mobile-first.
        Thus add the view port conf as meta tag.
        
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="utf-8"> 
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
            </head>
            <body>
            </body>
            </html>
            

    Bootstrap Container classes
    -------------------------------

        .container			creates a fixed width container
        .container-fluid	creates a full fixed width container

    Grid classes
    -------------------------
        
        row		will create a responsive row
        
        col-gridType-gridSize
            
            gridType
                xs (for phones - screens less than 768px wide)
                sm (for tablets - screens equal to or greater than 768px wide)
                md (for small laptops - screens equal to or greater than 992px wide)
                lg (for laptops and desktops - screens equal to or greater than 1200px wide)
            
            gridSize	from 1 to 12.
            
    Bootstrap Typography
    --------------------

        <h1> - <h6>
        <small>
        <mark>
        <abbr>
        <blockquote>
        .blockquote-reverse
        <dl>,<dt>,<dd>
        <code>
        <kbd>
        
        .text-muted
        .text-primary
        .text-success
        .text-info
        .text-warning
        .text-danger
        
        .bg-primary
        .bg-success
        .bg-info
        .bg-warning
        .bg-danger

        .lead			Makes a paragraph stand out	   
        .small			Indicates smaller text (set to 85% of the size of the parent)	   
        .text-left		Indicates left-aligned text	   
        .text-center	Indicates center-aligned text	   
        .text-right		Indicates right-aligned text	   
        .text-justify	Indicates justified text	   
        .text-nowrap	Indicates no wrap text	   
        .text-lowercase	Indicates lowercased text	   
        .text-uppercase	Indicates uppercased text	   
        .text-capitalize	Indicates capitalized text	   
        .list-unstyled	Removes the default list-style and left margin on list items 
        .list-inline	Places all list items on a single line	   
        
    Bootstrap tables  classes
    -------------------------

        .table
        .table-striped
        .table-bordered
        .table-hover
        .table-condensed		saves spaces by reducing cell-padding
        .table-responsive		allows horizontal scrolling on small screens
        
        classes for tr and td for contexual formating
        ---------------------------------------------
        .active		Applies the hover color to the table row or table cell
        .success	Indicates a successful or positive action
        .info		Indicates a neutral informative change or action
        .warning	Indicates a warning that might need attention
        .danger		Indicates a dangerous or potentially negative action
        
    Bootstrap image formating classes
    ----------------------------------------
    .img-rounded	Adds rounded corners to an image 
    .img-circle		Shapes the image to a circle 
    .img-thumbnail	Shapes the image to a thumbnail	
    .img-responsive	Makes an image responsive 

    Bootstrap button formating classes
    ------------------------------------------
        
        .btn
        .btn-default
        .btn-primary
        .btn-success
        .btn-info
        .btn-warning
        .btn-danger
        .btn-link
            
        .btn-group		groups a set of buttons in a packed contaienr.
        .btn-group-lg
        .btn-group-vertical
        .btn-group-justified
        
    form styling
    ------------------------------
        .form-control	for form elements for auto bootstrap styling
        
        Bootstrap provides three types of form layouts:

            Vertical form 		(this is default)
            Inline form			.form-inline
            Horizontal form		Add class .form-horizontal to the <form> element
                                Add class .control-label to all <label> elements
        
        Standard rules for all three form layouts:

            Wrap labels and form controls in <div class="form-group"> (needed for optimum spacing)
            Add class .form-control to all textual <input>, <textarea>, and <select> elements

        
    Special Contaienrs
    ----------------------------------
    .jumbotron 	 displayed as a grey box with rounded corners. It also enlarges the font sizes of the text inside it.
    
    .well class adds a rounded border around an element with a gray background color and some padding:

        alert alert-success
        alert alert-info
        alert alert-warning
        alert alert-danger
            
            will create a closable alert container, add
            fade and in classes for fade effects.

    
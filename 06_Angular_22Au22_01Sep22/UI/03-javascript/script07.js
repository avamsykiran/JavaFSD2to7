//call backs: a function passed to another function as a param.

const welcome = () => "Hai! You are welcome!";

const greetByTime = () => {
    let h = (new Date()).getHours();
    
    let greeting="";

    if(h>=3 && h<=11) greeting="Good Morning";
    else if(h>=12 && h<=16) greeting="Good Noon";
    else greeting="Good Evening";

    return greeting;
};

const greet = (userName,greetProvider) => console.log(greetProvider() + " " + userName);

greet("Vamsy Kiran",welcome);
greet("Vamsy Kiran",greetByTime);
greet("Vamsy Kiran",() => "Namsthey");

//Functions Demo

function greet(){
    console.log("Hello");
}

const greetUser = function(user){
    console.log("Hello "+user);
}

const welcome = () => "Hai! You are welcome!";

const welcomeUser = user => "Hello! "+user+" you are welcome";

const greetByTime = () => {
    let h = (new Date()).getHours();
    
    let greeting="";

    if(h>=3 && h<=11) greeting="Good Morning";
    else if(h>=12 && h<=16) greeting="Good Noon";
    else greeting="Good Evening";

    return greeting;
};

const simpleInterest = (p,t,r) => ((p*t*r)/100);

greet();
greetUser("Vamsy");

console.log(welcome());
console.log(welcomeUser("Vamsy"));
console.log(greetByTime())
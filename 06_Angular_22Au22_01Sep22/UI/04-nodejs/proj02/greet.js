
const getGreetingBytime = () => {
    let h = (new Date()).getHours();

    let greeting = "";

    if(h>=3 && h<=11) greeting = "Good Morning";
    else if(h>=12 && h<=16) greeting="Good Noon";
    else greeting="Good Evening";

    return greeting;
}

const greetUser = userName => `${getGreetingBytime()} ${userName}`;

export default greetUser;
//Asynchronous Programming 

const f1 = (word) => {
   let count=1;
   let handle = setInterval(
                    ()=>{
                        console.log(word);
                        count++;
                        if(count>10){
                            clearInterval(handle);
                        }
                    },
                    500
                );
}

f1("Hello");
f1("Hai");

console.log("I am from the main executor");
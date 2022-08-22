//Asynchronous Programming 

class NumberSeries {
    constructor(lb,ub){
        this.lb=lb;
        this.ub=ub;
    }

    generateSeries(){
        return new Promise((resolve,reject) => {

            if(this.lb>this.ub){
                reject(`${this.lb} is greter than ${this.ub}, hence not valid to generte series`)
                return;
            }

            let n = this.lb;
            let handle = setInterval(
                () => {
                 console.log(n);
                 n++;
                 if(n>this.ub){
                     clearInterval(handle);
                     resolve(`Numbers from ${this.lb} to ${this.ub} are generated.`)
                 }
                },500
            );    
        })
    }
}

let p1 =(new NumberSeries(10,20)).generateSeries();
let p2=(new NumberSeries(110,120)).generateSeries();
let p3=(new NumberSeries(210,120)).generateSeries();

p1.then(
    msg => console.log(msg),
    err => console.log(err)
);

p2.then(
    msg => console.log(msg),
    err => console.log(err)
);

p3.then(
    msg => console.log(msg),
    err => console.log(err)
);
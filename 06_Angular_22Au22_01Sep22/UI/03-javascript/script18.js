//Asynchronous Programming 

class NumberSeries {
    constructor(count){
        this.count=count;
    }

    generateRandomNumbers(){
        return new Promise((resolve,reject) => {

            if(this.count<0){
                reject(`${this.count} is negative hence can not proceed`)
                return;
            }

            let i=1;
            let sum=0;
            let handle = setInterval(
                () => {
                 let n = Math.trunc(Math.random()*100);
                 console.log(n);
                 sum+=n;
                 i++;
                 if(i>this.count){
                     clearInterval(handle);
                     resolve(sum);
                 }
                },500
            );    
        })
    }
}

let p1 = (new NumberSeries(10)).generateRandomNumbers();
let p2 = (new NumberSeries(-5)).generateRandomNumbers();

p1.then(
    s => console.log(`Total Sum is ${s}`),
    err => console.log(err)
);

p2.then(
    s => console.log(`Total Sum is ${s}`),
    err => console.log(err)
);

//Asynchronous Programming 

class NumberSeries {
    constructor(lb,ub){
        this.lb=lb;
        this.ub=ub;
    }

    generateSeries(){
        let n = this.lb;
        let handle = setInterval(
            () => {
             console.log(n);
             n++;
             if(n>this.ub){
                 clearInterval(handle);
             }
            },
            500
        );
    }
}

(new NumberSeries(10,20)).generateSeries();
(new NumberSeries(110,120)).generateSeries();

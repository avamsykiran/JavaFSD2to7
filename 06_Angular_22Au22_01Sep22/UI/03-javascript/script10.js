//closure: is a function that returns another funciton...

class Emp{
    constructor(id,name,sal){
        this.id=id;
        this.name=name;
        this.sal=sal;
    }

    ta(){
        return this.sal*0.2;
    }

    totalPay(){
        return this.sal+this.ta();
    }
}

const idClosure = () => { let id = 0; return (() => ++id); }
const getNextId = idClosure();

let e1 = new Emp(getNextId(),"Vamsy",5678);
let e2 = new Emp(getNextId(),"Rama",5678);
let e3 = new Emp(getNextId(),"Sita",5678);

console.log(e1);
console.log(e2);
console.log(e3);

//Arrays

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

let emps = [
    new Emp(getNextId(),"Vamsy",12345),
    new Emp(getNextId(),"Suma",10345),
    new Emp(getNextId(),"Rani",22345),
    new Emp(getNextId(),"Vinay",2345),
    new Emp(getNextId(),"Latha",42345),
    new Emp(getNextId(),"Vasu",19345),
    new Emp(getNextId(),"Vijay",12375),
    new Emp(getNextId(),"Vikram",12348),
    new Emp(getNextId(),"Vinodh",42345),
    new Emp(getNextId(),"Zubera",92345)
];

console.log(emps);

emps.pop(); //remove the last inserted element.
console.log(emps);

emps.splice(4,2);//removes the 4th and 5th elements
console.log(emps);

emps.push(new Emp(getNextId(),"Koaml",78900));
console.log(emps);

emps.sort((e1,e2) => e1.sal>e2.sal?1:(e1.sal<e2.sal?-1:0));
console.log(emps);

console.log(emps.find(e => e.sal===2345));
console.log(emps.find(e => e.sal===45));

console.log(emps.findIndex(e => e.sal===2345));
console.log(emps.findIndex(e => e.sal===45));

emps.forEach(e => e.sal=e.sal+(e.sal*0.05));
console.log(emps);

let names = emps.map(e => e.name);
console.log(names)

console.log(emps.filter(e => e.sal >= 20000))

let maxSalEmp = emps.reduce( (e1,e2) => e1.sal>e2.sal?e1:e2 )
console.log(maxSalEmp);

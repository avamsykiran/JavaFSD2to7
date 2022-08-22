//call and apply methods
//these methods are used on a function.

const estimatePaintingCost = function(paintingRate,tax) {
    return (this.area() * paintingRate) + (this.area() * paintingRate * tax);
}

class Rectangle {
    constructor(l,b){
        this.length=l;
        this.breadth=b;
    }

    area(){
        return this.length*this.breadth;
    }
}

class Circle {
    constructor(r){
        this.radius=r;
    }

    area(){
        return Math.PI*Math.pow(this.radius,2);
    }
}

let rect = new Rectangle(10,20);
let cir = new Circle(3.45);

console.log(rect);
console.log(cir);

console.log(estimatePaintingCost.call(rect,10,0.1));
console.log(estimatePaintingCost.call(cir,10,0.1));

console.log(estimatePaintingCost.apply(rect,[10,0.1]));
console.log(estimatePaintingCost.apply(cir,[10,0.1]));

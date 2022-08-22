//default params

const greet = (userName="Somebody") => "Hello "+userName;

console.log(greet());
console.log(greet("Vamsy"));

//rest params

/*const sum = (...nums) => {
    let s =0;
    for(let i=0;i<nums.length;i++){
        s+=nums[i];
    }
    return s;
}*/

const sum = (...nums) => !nums || nums.length===0 ? 0: nums.reduce((n1,n2)=> n1+n2);

console.log(sum(10,20))
console.log(sum(10,20,30))
console.log(sum(10,20,30,40))
console.log(sum())




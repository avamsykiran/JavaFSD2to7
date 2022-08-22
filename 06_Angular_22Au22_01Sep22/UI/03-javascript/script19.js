//async and await

/*let countFactors = n => new Promise((resolve,reject) => {
    console.log(`counting the factors of ${n}...`)

    if(n===0){
        reject("Zero is neither prime nor composite");
        return;
    }

    let count =2;
    let f = 2;
    let handle = setInterval(()=>{
        if(n%f==0){
            count++;
        }
        f++;
        if(f>n/2){
            clearInterval(handle);
            resolve(count);
        }
    },500);
} )*/

let countFactors = async n => {
    console.log(`counting the factors of ${n}...`)

    if (n === 0) {
        throw new Error("Zero is neither prime nor composite");
    }

    let count = 2;
    for (let i = 2; i <= n / 2; i++) {
        if (n % i == 0) {
            count++;
        }
    }
    return count;
}

let pickPrimes = async (...nums) => {
    let noOfPrimes = 0;
    for (let n of nums) {
        try {
            let c = await countFactors(n);
            if (c === 2) {
                console.log(`${n} is Prime`)
                noOfPrimes++;
            } else {
                console.log(`${n} is not Prime as it has ${c} factors`)
            }
        } catch (error) {
            console.log(error.message);
        }
    }
    return noOfPrimes;
}

pickPrimes(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
.then(priemsCount => console.log(`${priemsCount} primes found`));
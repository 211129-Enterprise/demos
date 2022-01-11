console.log("In the functions script");

//Classic Function Delcaration ==============================================
function divide1(x,y) {
    if (y > 0 && x > 0) {
        return x/y;
    } else {
        return 0;
    }    
}
let x = 10;
let y = 2;

let quotient = divide1(x,y);
console.log(x + " divided by " + y + " is equal to " + quotient);
console.log(`${x} divided by ${y} is equal to ${quotient}`); //better way

//Function expression ======================================================
const divide2 = function(x,y){
    if (y > 0 && x > 0) {
        return x/y;
    } else {
        return 0;
    }
}
console.log(divide2(100, 20));
console.log(divide2("apple", 2));

//Arrow Functions added in ES6 ==============================================
const divide3 = (x, y) => {
    if (y > 0 && x > 0) {
        return x/y;
    } else {
        return 0;
    }
}

//Concise Arrow Function Expressions ========================================
const divide4 = (x,y) => x/y;


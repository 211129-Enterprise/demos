console.log('In the functions script!') // in node we're not declaring this function against the window object but instead against the "global object"

// 4 ways to decalre a function in JS (as of ES6)

// 1. classic function declaration 
function divide1(x, y) {
    return x/y;
}

let x = 10;
let y = 2;

let quotient = divide1(x, y); // here we're storing the return value of that function to a variable

// console.log(x + ' divided by ' + y + ' is equal to ' + quotient)
// using a template literal
console.log(`${x} divided by ${y} is equal to ${quotient}`) // template literals were also introduced in ES6

// 2. Function expression - assign an anponymous function to a variable called divide2
const divide2 = function(x, y) {
    return x/y;
} 

let num1 = 100;
let num2 = 0;

if (num1 > 0 && num2 > 0) {

    console.log(divide2(num1, num2)); // a callback is where you pass a reference to a function as a parameter to a method

} else {
    console.warn("You can't divide by zero!")
}


console.log(divide2("apple", 2)); // returns NaN (NaN itself is a numeric type) and represents a value that can't be deduced to a number

// 3. Arrow Functions Expression (introduced in ES6 2015)
const divide3 = (x, y) => {
    return x/y;
}

// 4. Concise Arrow Function Expression
const divide4 = (x, y) => x/y;


let scores = new Array(10); // Array Constructor

console.log(scores);

let colors = ['red', 'blue', 'green'];
console.log(colors);

// accessing elements within the array
console.log(colors[1]) // returns the second element which is blue
colors[2] = 'purple' // reassign elements
console.log(colors);

let size = colors.length;

// JS arrays are dynamic and can change is size you can call push to add items and pop to remove the last element
colors.push('yellow');
console.log(colors)
let removedEl = colors.pop();

console.log(colors)
// to remove the first element instead you use shift()
colors.shift() // remove red;
console.log(colors.indexOf('purple')) // -1 idf it doesn't exist
console.log(colors)

let a = "ten";
let b = 10;
let c = true;
let d = {};
let e = null;
let f = "";
let g = 0;
let h = [];
let i = function(){}; // assigning the variable i to an anonymous function

const list = [a, b, c, d, e, f, g, h, i];

// var myArr = new Array(4, 33, 102);
// document.write(myArr.constructor)

// iterated over all the objects in list
for (let j =0; j< list.length; j++) {

    console.log(list[j])
}

// for in loop, returns the INDEX of each element in the list
for (let elIndex in list) {
    console.log(list[elIndex])
}

// for OF loop returns the actual element
for (let el of list) {
    console.log(el)
}



// a Callback is a function that's passed as a parameter to another function
list.forEach(printSomething);

list.forEach( // anonymous function
    function(input) {
        console.log(input)
    }
);

// concise arrow function (thanks to ES6)
list.forEach((input) => console.log(input));

list.forEach((input) => {
    console.log(input);
})

// functions (and variables declared with var, albeit undefined) are hoisted 
function printSomething(input) {

    console.log(input)


}
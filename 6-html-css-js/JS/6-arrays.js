let scores = new Array(10);

console.log(scores);

let colors = ['red', 'blue', 'green'];
console.log(colors);

// accessing elements within the array
console.log(colors[1]); // returns the second element which is blue
colors[2] =  'purple'; //reassign elements
console.log(colors);

let size = colors.length

// JS arrays are dynamic and can change in size, you can call push to add and pop to remove the last element
colors.push('green')
console.log(colors);
colors.pop();
console.log(colors);
colors.shift();
console.log(colors);
colors.unshift('red');
console.log(colors);

let a = 'ten';
let b = 10;
let c = true;
let d = {};
let e = null;
let f = '';
let g = 0;
let h = [];
let i = function(){}; // assigning variable i to an anonymous function

const list = [a,b,c,d,e,f,g,h,i,];

list.push('help');
console.log(list);
// var myArr = new Array(4, 33, 102);
// document.write(myArr.constructor);

// iterated over all objects in list
for (let j = 0; j < list.length; j++) {
  console.log(list[j]);
}

// for in loop

for (let index in list) {
  console.log(list[index]);
}

for (let el of list) {
  console.log(el);
}

// a CallBack is a function that's passed as a parameter to another function
list.forEach(printSomething);
list.forEach(function(input) {
  console.log(input);
})

// concise arrow function
list.forEach((input) => console.log(input))

list.forEach((input) => {
  console.log(input);
})



function printSomething(input) {
  console.log(input);
}
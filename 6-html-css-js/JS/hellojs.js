console.log("Hello World!")

/**
 * PRIMITIVE DATATYPES
 * 
 * - boolean
 * - number
 * - string
 * - null
 * - undefined
 * 
 * REFERENCE DATATYPES
 * - objects
 * - arrays
 * - functions (it's an object)
 */

// How do we decalre a variable?
// up until 2015, every variable was declared with var
var num = 5; // the primitive data type of "number" is automatically inferred upon initlaization of the variable
console.log(typeof(num)) // typof returns the datatype in the form of a string (so if it's a number it returns "number")

num = 'five'; // declaring a string with '', but you can also use ""

console.log(typeof(num))

console.log(num); // prints the word 5

// every variable declared with var against the window object is global

// in 2015 a new stndardization of JS was introduced called ECMAScript 6 -> introduced new ways of declaring variables: LET & CONST

let fruit = 'apple';
console.log(fruit)

// we can change the value of fruite
fruit = 'orange';
console.log(fruit);
fruit = 32;


const animal = 'elephant';
// animal = 'tiger'; // this will throw an error at runtime because you can't reassign a variable decalred with const

console.log(animal)
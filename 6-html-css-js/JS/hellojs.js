console.log("Hello World!")

/**
 * Primitive Datatypes
 * 
 * - boolean
 * - number
 * - string
 * - null
 * - undefined
 * 
 * Reference Datatypes
 * - objects
 * - arrays
 * - functions (it's an object)
 */

/**
 * How do we declare a variable?
 * up until 2015, every variable was declared with var
 */
var num = 5; // the primitive data type of "number" is automatically inferred upon initialization of the variable
console.log(typeof(num)); // typeof returns the datatype in the form of a string ( so if it's a number, it returns number)
num = 'five'; // declaring  string witih '' or ""
console.log(typeof(num));

console.log(num); // prints the word 5

// every variable declared with var against the window object is global

// 2015 a new standardization of JS was introduced called ECMAScript 6 -> introduced new ways of declaring variables: let & const

let fruit = 'apple';
console.log(fruit);

// we can change the value of fruit
fruit = 'orange';
console.log(fruit);
fruit = 42;
console.log(fruit);

const animal = 'elephant';
// animal = 'cat';
console.log(animal);
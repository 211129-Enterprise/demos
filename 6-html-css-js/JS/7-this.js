/**
 * What is THIS?
 * 
 * In JS, the "this" keyword refers to the object that it belongs to.
 * 
 * - alone, this refers to the global object
 * - in a FUNCTION, this still refers to the global object
 * - in a METHOD (a method is a function that belongs to an object) this refers to the owner object
 * - in strict mode, this in a function returns undefined
 */
'use strict' // ES5 introduced strict mode

var x = 10; // as if declared with var

console.log(x);

console.log(this); // this is the global object in Node, window in browser

function foo() {

  console.log(this) // returns undefined in strict mode

}

foo();

// to bind an object or variable to global object
this.cat = "Finn";
let cat = "Rynn";

console.log(this.cat);
console.log(cat);

//object literal
const person = {

    firstName: "Bob",
    lastName: "Smith",
    id: 123456789,
    sayFullName: function() { //this is a method because it's a function that belongs to an object
      return this.firstName + ' ' + this.lastName;
    }

}

console.log(person.sayFullName);

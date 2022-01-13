/**
 * What is THIS?
 * 
 * In JS, the "this" keyword refers to the object that it belongs to.
 * 
 * - alone, this refers to the global object
 * - in a FUNCTION, this still refers to the global object
 * - In a METHOD (a method is a functino that belongs to an object) this refers to the owner object
 * - in strict mode, this in a function returns undefined
 */
// 'use strict' // ES5 introduced strict mode

// strict mode prohibits us from declaring variables without a keyword
//x = 10; // as if I had declared with var

// console.log(x);

console.log(this); // this is the global object in Node, window in browser

function foo() {
    console.log(this) // returns undefined instrict mode
}

foo();

// to bind an object or variable to global object

this.cat = "Finn";

console.log(this.cat);

// obj literal
const person = {

    firstName: "Bob",
    lastName: "Smith",
    id: 1234,
    sayFullName: function() { // this is a method because it's a function that belogns to an object
        return this.firstName + ' ' + this.lastName;
    }
}

console.log(person.sayFullName())

console.log(this.cat); // this calls the cat property we bound to the global object







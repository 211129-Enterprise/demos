/**
 * 4 main scopes in JS
 * 
 * 1. Global - variables declared here are accessible anywhere
 * 2. Functional/Local scope - variables declared within a function are ONLY accessible within the function
 * 3. Block Scope (anything in between {})
 * 4. Lexical Scope( When you nest functions within each other - closure)
 */

//var is globally scoped
// let & const are block scoped (introduced in ES6)

var foo = 'Foo'; // globally scoped (it's now a property of the window)
let /* or const */bar = 'Bar'; // not allowed to be globally scoped - this is scoped to the context of this particular script (this block)
//console.log(window.foo); // foo
// console.log(window.bar); // undefined,

function funScope() {

  // bar ="Far " // this would change the value of bar in the outer scope
     let bar = "Car"; // you can re-declare a vairbale that declared as something else in the outer scope
     console.log(`This is the value of bar after reassignment in the function scope: ${bar}`); // we can access the this variable declared in the outer scope of this function
 
     // let bar = "Tar"; you CAN'T redeclare let (or const)
 
     const c = "cat";
     
 
     var x = "xylophone"; // this is declared at functional scope
  
     // you CAN redeclare the variable x
     var x  = 1;
 
     // block scope
     if (true) {
         console.log(c) // we can access the variables declared in the funciton this block is in
 
         if (true) {
             const l = "lion";
 
             if (true) {
 
                 console.log(l);
             }
         }
         //console.log(l); // this is unreachable because we can't access it 
     }
 }

console.log(`This is the value of bar in the outer scope: ${bar}`);
// console.log(c); // we can't access a variable in a function scope from outside of the function
// console.log(e); // we can't access a variable in a function scope from outside of the function
funScope();

console.log(`This is the value of bar in the outer scope after reassigning it in funScope: ${bar}`);
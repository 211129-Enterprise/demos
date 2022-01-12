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
// console.log(window.foo);
// console.log(window.bar);

function funScope() {
  
  let bar = "Car"; 
  console.log(`This is the value of bar after redeclaring it in the function scope: ${bar}`);
  
  const c = 'cat';
  var e = 'elephant';
  // block scope
  if (true) {
    console.log(c) // we can access the variables declared in the function this block is in
    if (true) {
      const l = 'lion'
      console.log(l);
    }
  }
}

console.log(`This is the value of bar in the outer scope: ${bar}`);
// console.log(c); // we can't access a variable in a function scope from outside of the function
// console.log(e); // we can't access a variable in a function scope from outside of the function
funScope();

console.log(`This is the value of bar in the outer scope after reassigning it in funScope: ${bar}`);


/**
 * 4 main scopes in JS
 * 
 * 1. Global - variable declared here are aceesible ANYWHERE
 * 2. Functional/Local scope - variables declared iwthin a fucntion are ONLY accesible within the function
 * 3. Block Scope (anything in between {} )
 * 4. Lexical Scope (when you nest functions within eachother - closure)
 */

// var is globally scopes
// let & const are block scoped  (introduced in ES6)

var foo = "Foo"; // globally scoped (it's now a property of the windo object)
let /* or const */ bar = "Bar"; // not allowed to be globally scoped - this is scoped to the context this particular script (this block)

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


// let bar = "Far"

console.log(`This is the value of bar in the outer scope ${bar}`)
// console.log(c); // we can't access a variable in a fucntion scope from OUTSIDE of the function

funScope();

// we have reassigned the value here when we call it again
console.log(bar);
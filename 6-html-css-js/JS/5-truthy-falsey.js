/**
 * JS has a special way of coercing all different types to a boolean value of either true or false
 * 
 * There are only 6 Falsey Values and everything else is Truthy
 * 
 * - 0
 * - null
 * - empty string
 * - false
 * - NaN
 * - undefined
 * 
 * !! double bang operator will check for a variables truthy or falsey value
 */


function checkTruthy(input) {

    console.log(`

        input is ${input} and is of type ${typeof(input)}
        It has a truthy value of ${!!input}
    `)
}

let username = 'spongebob'; // remeber in JS you can declare a string with either "" '', and in ES6 you can use a template literal with ``
let age = 0

let emptyArr = [];
let arrLength = [].length;

checkTruthy(age);
checkTruthy('apple' * 15); // NaN
checkTruthy({}); // truthy!
checkTruthy([]); // truthy!
checkTruthy(arrLength); // falsey because it's equal to 0


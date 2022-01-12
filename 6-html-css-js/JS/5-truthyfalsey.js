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
 * !! bang operator will check for a variables's truthy or falsey value 
 */

function checkTruthy(input) {

  console.log(`

    input is ${input} and is of type ${typeof(input)}
    It has a truthy value of ${!!input}
  `)
  
  
}
let username;
let age = 0;
checkTruthy(0);
checkTruthy(username);
checkTruthy('apple' * 15); // NaN
checkTruthy({});
checkTruthy([]);
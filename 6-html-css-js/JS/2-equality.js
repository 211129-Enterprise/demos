/**
 * Equality (== vs. ===) and the equals operator (=)
 * 
 * = is an assignment operator
 * == compares the value of objects on either side, but performs type coercion
 * === compares the value and type of objects on either side
 */

console.log(2 =='2'); // true - implements type coercion
console.log(2 === '2'); // false - value and type

function compare(first, second) {

  console.log(`
    first param = ${first}, and is of type ${typeof(first)}
    first param = ${second}, and is of type ${typeof(second)}

    Is first == second? : ${first == second}
    Is first == second? : ${first === second}
    
  `)

}

compare(2,'2');
compare('two', '2');
compare({},{});
compare([],null);
compare([],[]);

let coolString = `He said "hello there!"`;
console.log(coolString);
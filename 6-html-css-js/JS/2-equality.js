/**
 * Equality (== vs. ===) and the equals operator (=)
 * 
 * = is an assignment operator
 * 
 * == compares an object on either side's value, but performs something called type coercion
 * 
 * === compares both value and type on either side of the ===
 */


console.log(2 == '2'); // true - == implemnents type coercion
console.log(2 === '2') // false 

function compare(first, second) {

    console.log(`
    
        first param = ${first}, and is of type ${typeof(first)}
        first param = ${second}, and is of type ${typeof(second)}
        
        Is first == second? : ${first == second}
        Is first === second? : ${first === second}

    `)
}

compare(2, '2');
compare("two", '2')
compare({}, {}); // false, false even 2 empty objects do NOT have the same vlaue in JS 
compare([], null);

let coolString = `He said "hello there!"`;
console.log(coolString);

// arrays
// OOP in Javascript
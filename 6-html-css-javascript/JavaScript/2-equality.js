console.log("Hello equality");

console.log(2== "2"); //Boolean
console.log(2=== "2"); //Compares  both value and typeof. Since "2" is string, = false.

function compare(first, second) {

    console.log(`
    first param = ${first}, and is of type ${typeof(first)}
    first param = ${second}, and is of type ${typeof(second)}

    is first == second? : ${first == second}
    is first === second? : ${first === second}
    `)
}

compare(2, "2");
compare("two", 2);
compare({}, {});
compare([], null);

let coolString = "he said, 'Hello There!'";
console.log(coolString);

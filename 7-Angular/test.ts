//tsc test.ts
function doSomething() {

    for (var i = 0; i < 5; i++) { // functionally scoped
        console.log(i);
    }

    console.log('i is ' + i); // TypeScript compiler is informing us that i is unreachable
    // at the end of the day ALL TS will be transpiled eventually into javascript 
}

console.log(i); //
doSomething();
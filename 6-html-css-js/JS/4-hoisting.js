/**
 * JavaScript Execution Context
 * 
 * Everytime a JS engine executes a script, an Execution context is built.
 * 2 Phases--creation and execution
 */

/**
 * Creation Phase (STEP 1)
 * 
 * 1. Create the Global Object - web browser(window) -> Node = global object
 * 
 * 2. Bind "this" to the Global Object
 * 
 * 3. Set up a memory heap for storing variables and function reference.
 * 
 * 4. Store the function declarations in the memory heap and store variables within the execution context
 * as undefined (initialized but not declared)
 */

/**
 * Execution Phase (STEP 2)
 * 
 * JavaScript engine executes the code line by line. In this phase, it assigns the values to variables
 * and executes the function calls.
 * 
 * During execution phase variable hoisting occurs
 */

console.log(a); // undefined as if we have not initialized the variable
var a = 'apple';

// are variables defined with let & const hoisted
let b = 'banana';
console.log(b); // variables declared with let & const must be initialized before being called (otherwise throws an error)
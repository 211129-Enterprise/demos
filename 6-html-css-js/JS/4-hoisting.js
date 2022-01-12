/**
 * JavaScript Execution Context
 * 
 * Everytime a JS engine executes a script, an Execution context is built.
 * 2 Phases--creation and execution
 */

/**
 * Creation Phase (STEP 1)
 * 
 * 1. Create the GLobal Object - web browser (window) -> Node = global object
 * 
 * 2. Bind "this" to the Global Object
 * 
 * 3. Setup a memory heap for storing variables and function references.
 * 
 * 4. store the function declarations in the memory heap and store variables within the global execution context
 * as undefined (declared but not initliazed)
 */

/**
 * Execution Phase (Step 2)
 * 
 * JavaScript engine executes the code line by line.  In this phase, it assigns values to variables
 * and executes the function calls.
 * 
 * During execiutio  phase variable hoisting occurs
 */

console.log(a); // undefined as if we have not intialized the variable
var a = "apple";

// are variables defined with let & const hoisted?
console.log(b); // variables declared with let & const must be intialized before being called (otherwise throws an error)
let /* const */ b = "banana" 



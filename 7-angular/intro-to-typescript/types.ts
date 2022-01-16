var count = 5;
// count = 'five'; // Typescript compiler prevents reassignment to another type!

let x = 10;
x = 20;

let a: string; // declare the variable and its type
a = 'apples';
a = "appricots";

let b:boolean = true;
let c:string = 'cat';
let d:any;
d = "dog";
d = {};
d = [1,3,4];

let e: any[] = [1, 'one', {}];
let f: string[] = ['cat', 'dog', 'elephant',]

console.log(e[2]);

enum Color {Red, Blue, Green}

console.log(Color.Blue);
let backgroundColor = Color.Blue;

/*
 * 1. Declare the URL that is the destination for our request
 */
// http://localhost:5000
const url = window.location.origin + ('/api');



/*
 * 2. Capture the button element and add some functionality to it
 */
let button = document.getElementById('btn');
button.addEventListener("click", addUser);



/*
 * 3. Create the addUser function
 *      This function will:
 *          - Capture input values
 *          - construct a JSON object
 *          - send the object to the PostMapping method in the API's controller
 */
function addUser(){

    // Concatenate the end point where we want to hit with a POST request
    const postUrl = url + "/users/add";

    // Build a user object from the input fields by querying the DOM
    let iFirstName = document.getElementById('firstName').value,
        ilastName = document.getElementById('lastName').value,
        iUsername = document.getElementById('username').value,
        iPassword = document.getElementById('password').value,
        iEmail = document.getElementById('email').value;

    

    //Build the object (this is an object literal)
    let user = {
        firstName: iFirstName,
        lastName: ilastName,
        username: iUsername,
        password: iPassword,
        email: iEmail
    }


    // We need to build our request options (header of the HTTP request)
    // (To transform a JS object into JSON you call the Stringify() method)
    const request = {
        
        method: 'POST',
        body: JSON.stringify(user),
        headers: {
            'Content-Type': 'application/json'
        }
    }


    
    // Convert response to JSON then print to console
    fetch(postUrl, request)
        .then(res => res.json())
        .then(res => console.log(res));
}
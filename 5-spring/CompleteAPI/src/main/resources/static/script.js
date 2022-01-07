/**
 * Declare the URL that is the destination for our request
 */
// http://localhost:5000
const url = window.location.origin + ('/api');

// capture the button element and add some functionality to it
let button = document.getElementById('btn');

button.addEventListener("click", addUser);


/**
 * addUser function below
 * 
 * This function will do the following:
 * 
 * - capture input values
 * - construct a JSON object
 * - send the object to the PostMapping method in the API's controller
 *  */ 

function addUser() {

    console.log("clicked!")

    // Concatenate teh end point where we want to hit with a POST request
    const postUrl = url + "/users/add";

    // Build a user object from the input fields by querying the DOM
    let ifirstName = document.getElementById('firstName').value;
    let ilastName = document.getElementById('lastName').value;
    let iusername = document.getElementById('username').value;
    let ipassword = document.getElementById('password').value;
    let iemail = document.getElementById('email').value;

    // build the object (this is an object literal)
    let user = {
        firstName: ifirstName,
        lastName: ilastName,
        username: iusername,
        password: ipassword,
        email: iemail
    }

    console.log(user);

    // we need to built our request options (header of the HTTP request)
    const request = {

        method: 'POST', 
        body: JSON.stringify(user), // to transform a JS object into JSON you call the Stringify() method
        headers: {
            'Content-Type': 'application/json'
        }
    }

    // we send the whole object to our controller at http:localhost:5000/api/users/add
    fetch(postUrl, request)
        .then(res => res.json())
        .then(res => console.log(res)); // print out the response from the server to the console of our dev toos
}
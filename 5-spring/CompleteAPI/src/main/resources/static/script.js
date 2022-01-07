/**
 * Declare the URL that is the destination for our request
 */

const url = window.location.origin+('/api');

// capture the button element and add some functionality to it
let btn = document.getElementById('btn');

btn.addEventListener("click", registerNewUser);

/**
 * registerNewUser function
 * 
 * This function will do the following:
 * 
 * - capture input values
 * - construct a JSON object
 * - send the object to the PostMapping Method in the API's controller
 */

function registerNewUser() {

    // concatenate the endpoint where we want to hit with a POST request
    const postUrl = url + "/users/new"

    // Build a user object from the input fields by querying the DOM
    let iFirstName = document.getElementById('firstName').value;
    let iLastName = document.getElementById('lastName').value;
    let iUsername = document.getElementById('username').value;
    let iPassword = document.getElementById('password').value;
    let iEmail = document.getElementById('email').value;

    // build the object (this is an object literal)

    let user = {
        firstName: iFirstName,
        lastName: iLastName,
        username: iUsername,
        password: iPassword,
        email: iEmail
    }

    // We need to build our request (header of the HTTP Request)
    const request = {
        method: 'POST',
        body: JSON.stringify(user),        //to transform a JS object to JSON, you call the Stringify() method
        headers: {
            'Content-Type': 'application/json'
        }
    }   
    
    fetch(postUrl, request)
        .then(res => res.json())
            .then(res => console.log(res));

}
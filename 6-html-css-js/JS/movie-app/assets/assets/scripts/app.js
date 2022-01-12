// capturing the ADD MOVIE button and storing it to a variable (it's an object)
const startAddMovieButton = document.querySelector('header button');
// capture the modal element by its ID
const addMovieModal = document.getElementById('add-modal')
const backdrop = document.getElementById('backdrop');
const cancelAddMovieButton = document.querySelector('.btn--passive');
const confirmAddMovieButton =  cancelAddMovieButton.nextElementSibling;
const userInputs = addMovieModal.querySelectorAll('input'); // selecting all of the input fields within an element and returning a collection

const toggleBackdropHandler = () => {
    backdrop.classList.toggle('visible') // backdrop.visible 
}

const cancelAddMovieHandler = () => {
    toggleMovieModal();
    clearMovieInput();
}

const clearMovieInput = () => {
    for (let usrInput of userInputs) {
        usrInput.value = '';
    }
}

const confirmAddMovieHandler = () => {
    // capture the value of the 3 input fields
    const titleValue = userInputs[0].value;
    const imageUrlValue = userInputs[1].value;
    const ratingValue = userInputs[2].value;

    // validate the input BEFORE constructing an object
    if (titleValue.trim() === '' || 
        imageUrlValue.trim() === '' || 
        ratingValue.trim() === '' ||
        +ratingValue < 1 ||
        +ratingValue > 5
    ) {
        window.alert('Please Enter valid values (raing must be between 1 and 5)')
        return;
    }
    // if it's valid input, construct a movie object
    const newMovie = {
        title: titleValue,
        image: imageUrlValue,
        rating: ratingValue
    }

    console.log(newMovie)
    clearMovieInput();

    // push the newMovie to an array of movie objects

    // call a renderNewMovieElement() to dynamically add the object to the user interface

}


const toggleMovieModal = () => {
    // capture the nmodal element and toggle its class to 'visible'
    addMovieModal.classList.toggle('visible');
    toggleBackdropHandler();
}

// function toggleMovieModal() {

// }

// Here we add an event listener so that when we click on the button, it invokes the toggleMovieModal() function above
startAddMovieButton.addEventListener('click', toggleMovieModal); // <- this is a callback!
backdrop.addEventListener('click', toggleMovieModal)
cancelAddMovieButton.addEventListener('click', cancelAddMovieHandler)
confirmAddMovieButton.addEventListener('click', confirmAddMovieHandler)


// capturing the ADD MOVIE button and storing it to a variable (it's an object)
const startAddMovieButton = document.querySelector('header button');
// capture the modal element by its ID
const addMovieModal = document.getElementById('add-modal')
const backdrop = document.getElementById('backdrop');
const cancelAddMovieButton = document.querySelector('.btn--passive');
const confirmAddMovieButton =  cancelAddMovieButton.nextElementSibling;
const userInputs = addMovieModal.querySelectorAll('input'); // selecting all of the input fields within an element and returning a collection
const entryTextSection = document.getElementById('entry-text');
const listRoot = document.getElementById('movie-list');

const movies = [];

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

const updateUi = () => {

    // check that the length of the movies array is or isn't === 0
    if (movies.length === 0) {
        // capture the element we want to affect
        entryTextSection.style.display = 'block';
    } else {
        entryTextSection.style.display = 'none'; // it dissapears!
    }

}

/**
 * Take in aparameters and build an HTML element to display on the UI
 */
const renderNewMovieElement = (title, imageUrl, rating) => {

    // createElement on the DOM
    const newMovieElement = document.createElement('li')

    // give the elemtna class-name
    newMovieElement.className = 'movie-element'

    // set the innerHTML of the element = to a a template literal which will
    newMovieElement.innerHTML = `
        <div class="movie-element__image">
            <img src="${imageUrl}" alt="${title}">
        </div>
        <div class="movie-element__info">
            <h2>${title}</h2>
            <p>${rating}</p>
        </div>
    `;

    // we need to append this element to an existing element on our DOM
    listRoot.append(newMovieElement);
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
        +ratingValue < 1 || // the plus sign will convert the string to a numeric type IF it's a number like '2'
        +ratingValue > 5 // kind of like Integer.parseInt()
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

    movies.push(newMovie);

    toggleMovieModal();
    clearMovieInput();

    renderNewMovieElement(newMovie.title, newMovie.image, newMovie.rating);

    // this function will remove the message if there are movies in the array

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


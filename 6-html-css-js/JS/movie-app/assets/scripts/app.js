// capture the add movie button and storing it to a variable
const startAddMovieButton = document.querySelector('header button');
// capture the modal element
const addMovieModal = document.getElementById('add-modal');
const backdrop = document.getElementById('backdrop');
const cancelButton = document.querySelector('.btn--passive');
const confirmAddMovieButton = cancelButton.nextElementSibling;
const userInputs = addMovieModal.querySelectorAll('input'); // selecting all of the input fields within an element and returning an array
const entryTextSection = document.querySelector('#entry-text');
const movies = [];

const clearMovieInput = () => {

  for (let usrInput of userInputs) {
    usrInput.value = '';
  }
}

const toggleMovieModal = () => {
  // capture the modal element, and toggle its class to visible
  addMovieModal.classList.toggle('visible');
  backdrop.classList.toggle('visible');
}

const updateUi = () => {
  // check that the length of the movies array is or isn't === 0
  if(!!!movies.length) {
    // capture the element we want to affect
    entryTextSection.style.display = 'block';
  } else {
    entryTextSection.style.display = 'none'; // it disappears!
  }
}

/**
 * Take in parameters and build an HTML element to display on the UI
 */
const renderNewMovieElement = (title, imageUrl, rating) => {
  // create an element on the DOM
  const newMovieElement = document.createElement('li')
  // give the element a className
  newMovieElement.className = 'movie-element'

  // set the innerHTML of the element = to a template literal which will display
  // the properties passed to this function
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
  const listRoot = document.getElementById('movie-list');
  listRoot.append(newMovieElement);

}

const confirmAddMovieHandler = () => {
  // capture the value of the input fields
  const titleValue = userInputs[0].value;
  const imageUrlValue = userInputs[1].value;
  const ratingValue = userInputs[2].value;

  // validate the input BEFORE constructing an object
  if (!!!titleValue.trim() || 
        !!!imageUrlValue.trim() || 
        !!!ratingValue.trim() ||
        +ratingValue < 1 ||
        +ratingValue > 5
  )  {
      window.alert('Please enter valid value ( rating must be between 1 & 5')
      clearMovieInput()
      return;
  }
  // if it's valid input, construct a movie object
  const newMovie = {
    title: titleValue,
    image: imageUrlValue,
    rating: ratingValue
  }
  // push the newMovie to an array of movie objects
  movies.push(newMovie);
  toggleMovieModal();
  clearMovieInput();
  
  // call a renderNewMovieElement() to add it to the interface
  renderNewMovieElement(newMovie.title,newMovie.image,newMovie.rating);

  // this function will remove the message if there are movies in the array
  updateUi();
}

// here we add an event listener so that when we click on the button, it invokes the toggleMovieModal() function
startAddMovieButton.addEventListener('click', toggleMovieModal);

// Challenge - make it so that when the user clicks the backdrop
backdrop.addEventListener('click', toggleMovieModal);
cancelButton.addEventListener('click', toggleMovieModal);
confirmAddMovieButton.addEventListener('click', confirmAddMovieHandler)

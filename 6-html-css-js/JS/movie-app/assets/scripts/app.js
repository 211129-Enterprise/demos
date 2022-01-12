// capture the add movie button and storing it to a variable
const startAddMovieButton = document.querySelector('header button');
// capture the modal element
const addMovieModal = document.getElementById('add-modal');
const backdrop = document.getElementById('backdrop');
const cancelButton = document.querySelector('.btn--passive');
const confirmAddMovieButton = cancelButton.nextElementSibling;
const userInputs = addMovieModal.querySelectorAll('input'); // selecting all of the input fields within an element and returning an array

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
  clearMovieInput()
  console.log(newMovie);

  // push the newMovie to an array of movie objects


  // call a renderNewMovieElement() to add it to the interface
}

// here we add an event listener so that when we click on the button, it invokes the toggleMovieModal() function
startAddMovieButton.addEventListener('click', toggleMovieModal);

// Challenge - make it so that when the user clicks the backdrop
backdrop.addEventListener('click', toggleMovieModal);
cancelButton.addEventListener('click', toggleMovieModal);
confirmAddMovieButton.addEventListener('click', confirmAddMovieHandler)

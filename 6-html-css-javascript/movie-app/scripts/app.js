//capture the add-modal element
console.log("Test movie log");
const startAddMovieButton = document.querySelector("header button");
const addMovieModal = document.getElementById("add-modal");
const cancelMovieButton = document.querySelector(".btn--passive");
const confirmAddMovieButton = cancelMovieButton.nextElementSibling;
const userInputs = addMovieModal.querySelectorAll("input");


const backDrop = document.getElementById("backdrop");
const toggleBackdropHandler = () => {
    backDrop.classList.toggle("visible");
}
const clearMovieInput = () => {
    for (let usrInput of userInputs) {
        usrInput.value = "";
    }
}
const cancelAddMovieHandler = () => {
    toggleMovieModal();
}
const confirmAddMovieHandler = () => {
//capture 3 input fields
const titleValue = userInputs[0].value;
const imageUrlValue = userInputs[1].value;
const ratingValue = userInputs[2].value;

//validate the input before constructing an object
if(titleValue.trim()==="" || imageUrlValue.trim() ==="" || ratingValue.trim() ==="" ||
    +ratingValue < 1 || +ratingValue >5) {
        window.alert("Please enter Valid values (rating must be between 1 - 5)" )
        return;
    }

//if its valid input, construct a movie object
const newMovie = {
    title: titleValue,
    image: imageUrlValue,
    rating: ratingValue
}
//call a renderMovieElement() to dynamically add the object to the user interface
console.log(newMovie);
clearMovieInput();
}

const toggleMovieModal = () => {
    console.log("Clicked!");
    startAddMovieButton.innerHTML = "Clicked!"
    addMovieModal.classList.toggle("visible");
    toggleBackdropHandler();
}


startAddMovieButton.addEventListener("click", toggleMovieModal);
backDrop.addEventListener("click", toggleMovieModal);
cancelMovieButton.addEventListener("click", cancelAddMovieHandler);
confirmAddMovieButton.addEventListener("click", confirmAddMovieHandler);
//challenge - make it so when a user clicks the button, darken the backdrop.
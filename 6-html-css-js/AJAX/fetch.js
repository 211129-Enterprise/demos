/**
 * The Fetch API provides us with a method called fetch() that allows us to
 * easily fetch resources asynchronously across a network
 */

const pokeId = document.getElementById('poke-id')
const respId = document.getElementById('resp-id')
const pokeName = document.getElementById('resp-name')
const pokeImg = document.getElementById('resp-sprite')
const button = document.getElementById('btn')

 button.addEventListener('click',fetchCall);

 function fetchCall() {

    let idNum = document.getElementById('poke-id').value;

  fetch(`https://pokeapi.co/api/v2/pokemon/${idNum}`)
       .then((response) => response.json()) // this parses the  body of the response into a JS object
       .then(renderPokemon, handleError); // we pass the js object into the function
  
 }

 function renderPokemon(data) {
    // we're going to modify the elements on the index.html page
    // by pluggin in thevalues of the properties of the data received
    // console.log(data.json())
    // data = JSON.parse(data);

    pokeName.innerHTML = `Name: ${data.name}`;
    respId.innerHTML = `Id: ${data.id}`;
    pokeImg.setAttribute("src", data.sprites.front_default);
    pokeImg.setAttribute("height", 300);
}

function handleError(error) {
  console.error(error);
}
/**
 * The Fetch API provides us with a method called fetch() that allows us to
 * easily fetch resources asynchronously acorss a netowork.
 */

 const pokeId = document.getElementById('poke-id')
 const respId = document.getElementById('resp-id')
 const pokeName = document.getElementById('resp-name')
 const pokeImg = document.getElementById('resp-sprite');
 const button = document.getElementById('btn')
 
 button.addEventListener('click', fetchCall);
 
 function fetchCall() {
 
 let idNum = document.getElementById('poke-id').value;
 
 fetch(`https://pokeapi.co/api/v2/pokemon/${idNum}`)
     .then((response) => response.json()) // this parses the body of the response into a JS object
     .then(renderPokemon, handleError); // we pass that JS object to that function here
 }
 
 function renderPokemon(data) {
     // we're going to modify the elements on the index.html page
     // by plugging in the values of the properties of the data recevievd
 
     pokeName.innerHTML = `Name: ${data.name}` // /name and .id have to be properties on the JSON object
     respId.innerHTML = `Id: ${data.id}`
 
     pokeImg.setAttribute("src", data.sprites.front_default);
 
     pokeImg.setAttribute("height", 300); 
 
 }
 
 function handleError(error) {
     console.error(error);
 }
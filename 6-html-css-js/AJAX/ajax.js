// grab the elements form the page to work with
const pokeId = document.getElementById('poke-id')
const respId = document.getElementById('resp-id')
const pokeName = document.getElementById('resp-name')
const pokeImg = document.getElementById('resp-sprite')
const button = document.getElementById('btn')

button.addEventListener('click', ajaxCall);

// const ajaxCall = () => {

// }

function ajaxCall() {
  // capture the id from the user input
  let idNum = pokeId.value;

  // 1. attain the XMLHttpRequestObject
  let xhr = new XMLHttpRequest();
    /**
     * 0. UNSENT: open() method has not been called 
     * 1. OPENED: open() method has been called
     * 2. HEADERS_REQUEST: send() method has been called and the ehaders + status code of the HTTP response are available
     * 3. LOADING: downloading the full response from the server
     * 4. DONE: entire operation is complete and now we have a server response.
     */
  xhr.onreadystatechange = function() {
    // this inside of a function refers to the object that's calling the function
    if (this.readyState == 4 && this.status == 200) {

      // if we have successfully received the response we need to transform it to a JS Object
      let respPokemon = JSON.parse(xhr.responseText);

      console.log(respPokemon);
      renderPokemon(respPokemon);
      
    }

  }

  xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${idNum}`); // pokeapi.com

  xhr.send();
}

function renderPokemon(data) {
  // we're going to modify the elements on the index.html page
  // by pluggin in thevalues of the properties of the data received

  pokeName.innerHTML = `Name: ${data.name}`;
  respId.innerHTML = `Id: ${data.id}`;
  pokeImg.setAttribute("src", data.sprites.front_default);
  pokeImg.setAttribute("height", 300);
}
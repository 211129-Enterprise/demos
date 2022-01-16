const button = document.querySelector('button');

function buttonClickHandler() {

  navigator.geolocation.getCurrentPosition(
    posData => {
      setTimeout(() => {
        console.log(posData) // a callback within a callback
      }, 2000)
    }, error => {
      console.log(error);
    });

  console.log('Getting Position');

}

button.addEventListener('click',buttonClickHandler);


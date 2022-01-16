const button = document.querySelector('button');

// 1. create a new function
const setTimer = (duration) => {

  const promise = new Promise((resolve,reject) => { // (() => {}, () => {})
    

    // this function is executed immediately when the promise is created
    setTimeout(() => { 
      // this code will only execute after the duraction that we've accepted as a parameter
      resolve('Done!') // this represents the data returned when successful
    }, duration)
  });
  return promise;

  
    

}

const getPosition = (opts) => {

  const promise = new Promise((resolve, reject) => {
    navigator.geolocation.getCurrentPosition(success => {
      resolve(success)
    },
    (error) => {},
    opts);
  });

  return promise;
}

function buttonClickHandler() {

  let positionData;

  getPosition().then(posData => {
    positionData = posData;
    return setTimer(2000);
    
  })
  .catch(err =>{
    console.log(err)
  })
  .then(data => { // data refers to what's being returned by setTimer's promise
    console.log(data, positionData);
  });
  // navigator.geolocation.getCurrentPosition(
  //   posData => { // the function to perform, when the position is returned, is to call another function which delays the printing of the data returned
  //     setTimer(2000).then(data => {
  //       console.log(data, posData);
  //     });
  //   }, error => {
  //     console.log(error);
  //   });

  console.log('Getting Position');

}

button.addEventListener('click',buttonClickHandler); // event loop place callbacks into a queue


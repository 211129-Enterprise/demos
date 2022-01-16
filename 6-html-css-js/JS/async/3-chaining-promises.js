const button = document.querySelector('button');
const setTimer = (duration) => {

  const promise = new Promise((resolve,reject) => {
    
    setTimeout(() => { 
      resolve('Done!')
    }, duration)
  });
  return promise;

  
    

}

const getPosition = (opts) => {

  const promise = new Promise((resolve, reject) => {
    // navigator.geolocation.getCurrentPosition(success => {}, error => {}, opts);
    navigator.geolocation.getCurrentPosition(
      (success) => {
      resolve(success)
    },
    (error) => {},
    opts);
  });

  return promise;
}

function buttonClickHandler() {

  let positionData;

  getPosition().then((posData) => {
    positionData = posData;
    return setTimer(2000);
    
  })
  .catch(err =>{
    console.log(err)
  })
  .then(data => { // data refers to what's being returned by setTimer's promise
    console.log(data, positionData);
  });

  console.log('Getting Position');

}

button.addEventListener('click',buttonClickHandler); // event loop place callbacks into a queue


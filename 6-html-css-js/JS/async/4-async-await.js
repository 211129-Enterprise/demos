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

async function buttonClickHandlerAsync() { // async implies that a function returns a promise
  
  console.log('Getting Position');
  
  const posData = await getPosition(); // await can ONLY be used within an async function
  const timerData = await setTimer(2000);

  console.log(timerData, posData);
  // let positionData;

  // getPosition().then(posData => {
  //   positionData = posData;
  //   return setTimer(2000);
    
  // })
  // .catch(err =>{
  //   console.log(err)
  // })
  // .then(data => { // data refers to what's being returned by setTimer's promise
  //   console.log(data, positionData);
  // });
  

}

button.addEventListener('click',buttonClickHandlerAsync); // event loop place callbacks into a queue


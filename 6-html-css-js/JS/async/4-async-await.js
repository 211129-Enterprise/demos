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
    navigator.geolocation.getCurrentPosition(success => {
      resolve(success)
    },
    (error) => {},
    opts
    );
  });
  return promise;

}

// async is Promisifying the function
async function buttonClickHandlerAsync() { // async implies that a function returns a promise
  
  console.log('Getting Position');
  
  const posData = await getPosition(); // await can ONLY be used within an async function
  const timerData = await setTimer(2000);

  console.log(timerData, posData);
}

button.addEventListener('click',buttonClickHandlerAsync); // event loop place callbacks into a queue


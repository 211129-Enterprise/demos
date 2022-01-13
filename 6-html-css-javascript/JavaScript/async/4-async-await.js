const button = document.querySelector("button");

const setTimer = (duration) => {
  const promise = new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("Done!");
    }, duration);
  });

  return promise;
};

const getPosition = (opts) => {
  const promise = new Promise((resolve, reject) => {
    // navigator.geolocation.getCurrentPosition(success => {}, error => {}, opts);
    navigator.geolocation.getCurrentPosition(
      (success) => {
        resolve(success);
      },
      (error) => {},
      opts
    );
  });

  return promise;
};

// async is Promisifying the function
async function buttonClickHandlerAsync() { // async implies that a function returns a Promisse
    
    console.log("Getting position");

    const posData = await getPosition(); // await can ONLY be used within an async function
    const timerData = await setTimer(2000);

    console.log(timerData, posData)


//   getPosition().then((posData) => {
    
//     positionData = posData; // setting the
//     return setTimer(2000);
//   })
//   .catch(err => {
//       console.log(err)
//   })
//   .then(data => { // data refers to what's being returned by  setTimes promise
//       console.log(data, positionData)
//   });
}

button.addEventListener("click", buttonClickHandlerAsync); // event loop place callbacks into a queue
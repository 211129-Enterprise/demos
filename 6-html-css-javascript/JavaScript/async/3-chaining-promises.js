const button =document.querySelector("button");
//a PROMISE is a function that will return a value at some point in time.
//1. create new function
const setTimer = (duration) => {
    const promise = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("Done!"); //a callback within a callback
        }, duration)
    } ); 
    return promise;
}

const getPosition =(opts) => {
    const promise = new Promise((resolve, reject) => {
        navigator.geolocation.getCurrentPosition(success => {
            resolve(success);
        },
        error => {
            opts;
        })
    })
     return promise;
}





function buttonClickHandler() {

    let positionData;
    getPosition().then(postData => {
        positionData = postData;
        return setTimer(2000);
    })
    .catch(err => {
        console.log(err);
    })
    .then(data => {
        console.log(data, positionData)
    });

    // navigator.geolocation.getCurrentPosition(
    //     postData => {
    //        setTimer(2000).then(data => { console.log(data, postData)})
    //     }, 
    //     error => {
    //         console.log(error);
    //     },
    //     )
        console.log("Getting Position")
}

button.addEventListener("click", buttonClickHandler);
console.log("I reached this line");
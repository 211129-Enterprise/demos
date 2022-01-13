const button =document.querySelector("button");
//a PROMISE is a function that will return a value at some point in time.
//1. create new function
const setTimer = (duration) => {
    const promise = new Promise((resolve, reject) => {
        
        setTimeout(() => {
            resolve("Done!"); //a callback within a callback
        }, duration)

    } ); //(() => {}, () => {});
    
    return promise;
}

function buttonClickHandler() {
    navigator.geolocation.getCurrentPosition(
        postData => {
           setTimer(2000).then(data => { console.log(data, postData)})
        }, 
        error => {
            console.log(error);
        },
        console.log("Getting Position")
        )
}

button.addEventListener("click", buttonClickHandler);

// let result = 0;
// for (let i=0; i<1000000; i++) {
//     result += 1;
// }

console.log("I reached this line");
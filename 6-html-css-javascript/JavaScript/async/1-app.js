const button =document.querySelector("button");

function buttonClickHandler() {
    navigator.geolocation.getCurrentPosition(
        postData => {
            setTimeout(() => {
                console.log(postData); //sent to the callback que. (anonynous function)
            }, 2000)
        }, 
        error => {
            console.log(error);
        })
        console.log("Getting Position")
}

button.addEventListener("click", buttonClickHandler);

// let result = 0;
// for (let i=0; i<1000000; i++) {
//     result += 1;
// }

console.log("I reached this line");
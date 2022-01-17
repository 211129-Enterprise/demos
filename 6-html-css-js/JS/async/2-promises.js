const button = document.querySelector('button');

// 1. create a new function
const setTimer = (duration) => {

    const promise = new Promise((resolve, reject) =>{
        // this function is executed immediately when the promise is created
        setTimeout(() => {
            // this code will only execute after the duraction that we've accepted as a parameter
            resolve('Done!') // this represents the data returned when successful
        }, duration)
    } );  

    return promise;
}

function buttonClickHandler() {

    navigator.geolocation.getCurrentPosition(
        posData => { // the function to perform, when the position is returned, is to call another function which delay the printing of the data returned
           
            setTimer(2000).then(data => {
                console.log(data, posData)
            })
        },  
        error => {
            console.log(error);
        });

    console.log('Getting Position')

}

button.addEventListener('click', buttonClickHandler); // event loop place callbacks into a queue

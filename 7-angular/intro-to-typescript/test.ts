function doSomething(){
  for (let i = 0; i < 5; i++) {
    console.log(i);
  }
  
  console.log('i is ' + i); // typescript compiler is informing us that i is unreachable
                            // all ts will be transpiled to js regardless of warning
}

doSomething();
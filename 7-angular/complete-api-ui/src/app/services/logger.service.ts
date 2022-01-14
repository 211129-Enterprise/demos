import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggerService { // we don't have a constructor because LoggerService does not depend on another service

  // log // if you place a ? infront of a parameter it will mark is as possibly undefined
  log(msg: any) { // modify line 8 in tsconfig to allow this
    console.log(msg);
  }

  // warn
  warn(msg: any) {
    console.warn(msg);
  }

  // error
  error(msg: any) {
    console.error(msg);
  }

}

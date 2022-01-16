import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggerService { // we don't have a constructor because LoggerService does not depend on another service

  /**
   * (msg? ) is the same as (msg: any | undefined)
   * this lets you 
   */
  // log
  log(msg: any) {
    console.log(msg);
  }

  // warn
  warn(msg: any) {
    console.log(msg);
  }

  // error
  error(msg: any) {
    console.log(msg);
  }

}

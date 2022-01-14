import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import { catchError, Observable, throwError } from 'rxjs';
import { awsUrl } from 'src/environments/environment';
import { LoggerService } from './logger.service';


const url = `${awsUrl}/users`; //http://completeapibeanstalk-env.eba-sfn83npg.us-east-1.elasticbeanstalk.com/api/users

@Injectable({ // We will inject this service into components.
  providedIn: 'root' // all services are singleton objects
})
export class UserService {
// A service is a class with a narro, well-defined purpose

  constructor(
    private http: HttpClient,
    public logger: LoggerService) {}

    // these are the headers that we append to every request to the server
    httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    }


  // GET
  findAllUsers(): Observable<User[]> {
    // send a GET request
    // from the values recieved in the HTTP repsonse, we need to return them OR handle the error
    return this.http.get<User[]>(url)
   // this will reach the rest controller of the Spring Boot API!!
      .pipe(catchError(this.handleError)); // very similar to .then() because it allows us to call a method on the data returned

  }

  // POST - //http://completeapibeanstalk-env.eba-sfn83npg.us-east-1.elasticbeanstalk.com/api/users/add
  registerUser(user: User): Observable<User> {
    // Sending a User object in the body of the request
    return this.http.post<User>(`${url}/add`, user, this.httpOptions)
      .pipe(catchError(this.handleError))
  }

  // DELETE

  // GET by ID

  private handleError(httpError: HttpErrorResponse) {

    if (httpError.error instanceof ErrorEvent) {
      console.log('An error occurred: ', httpError.error.message)
    } else {
      console.error(`
        Backend returned code ${httpError.status},
        body was: ${httpError.error}
      `);
    }

    // throwError is an Observable object from RxJS Reactive Extensions for JavaScript
    return throwError(() => new Error('Something really bad happened, please try again later'));
  }

}

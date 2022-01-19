import { LoggerService } from './logger.service';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http'
import { User } from '../models/user';
import { catchError, Observable, throwError } from 'rxjs';
import { awsUrl } from 'src/environments/environment'

const url = `${awsUrl}/users`;

@Injectable({ // we will inject this service into many components
  providedIn: 'root' // all services are singleton objects
})
export class UserService {

  constructor(
    public logger: LoggerService,
    private http: HttpClient) {}

    // these are the headers that we append to every request to the server
    httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    }

  // GET All
  findAllUsers(): Observable<User[]> {
    // send a GET request
    // from the values received in the response, we need to return them or handle an error
    return this.http.get<User[]>(url)
    // this will reach the rest controller of the Spring Boot API!!
      .pipe(catchError(this.handleError)); // very similar to .then() because it allows us to call a method on the data returned
  }

  // POST - http://completeapibeanstalk-env.eba-sfn83npg.us-east-1.elasticbeanstalk.com/api/users/add
  registerUser(user: User): Observable<User> {
    // Sending a User object in the body of the request
    return this.http.post<User>(`${url}/add`, user, this.httpOptions)
          .pipe(catchError(this.handleError));
  }

  // GET/1
  findUserById(id: number): Observable<User> {
    return this.http.get<User>(`${url}/${id}`)
    .pipe(
      catchError(this.handleError)
    );
  }

  // DELETE
  removeUserById(id: number) {
    return this.http.delete<User>(`${url}/${id}`)
    .pipe(
      catchError(this.handleError)
    );
  }



  private handleError(httpError : HttpErrorResponse) {

    if (httpError.error instanceof ErrorEvent) {
      console.log('An error occurred: ', httpError.error.message)
    } else {
      console.error(`
        Backend returned code ${httpError.status},
        body was: ${httpError.error}
      `)
    }
    // throwError is an Observable object from RxJS Reactive Extensions for JavaScript
    return throwError(() => new Error('Something really bad happened, please try again later'));
  };

}

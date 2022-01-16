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
  public findAllUsers(): Observable<User[]> {
    // send a GET request
    // from the values received in the response, we need to return them or handle an error
    return this.http.get<User[]>(url)
      .pipe(catchError(this.handleError));
  }

  // POST - http://completeapibeanstalk-env.eba-sfn83npg.us-east-1.elasticbeanstalk.com/api/users/add
  registerUser(user: User): Observable<User> {

    return this.http.post<User>(`${url}/add`, user, this.httpOptions)
          .pipe(catchError(this.handleError));
  }

  // GET/1


  // DELETE




  public handleError(httpError : HttpErrorResponse) {

    if (httpError.error instanceof ErrorEvent) {
      console.log('An error occurred: ', httpError.error.message)
    } else {
      console.error(`
        Backend returned code ${httpError.status},
        body was: ${httpError.error}
      `)
    }
    // throwError is an Observable object form RxJS Reactive Extensions for JavaScript
    return throwError(() => new Error('Something really bad happened, please tryi agin later'));
  };

}

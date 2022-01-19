import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { url } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class JwtClientService {

  constructor(private http: HttpClient) { } // make sure you impor tthe HttpClientModule to your app.module.ts


  // generateToken()
  public generateToken(request: any)  {

    // hit the /authenticate endpoint of our server
    return this.http.post(`${url}authenticate`, request, {responseType: 'text' as 'json'})
    // https://stackoverflow.com/questions/50798592/angular-6-how-to-set-response-type-as-text-while-making-http-call
    // https://angular.io/guide/http

  }

  // accessLogin(token) - send the request with the token TO the login() method in the server at "/"
  public acceessLogin(token:string) {

    let tokenStr = `Bearer ${token}`
    const headers = new HttpHeaders().set("Authorization", tokenStr);

    return this.http.get(url, {headers, responseType: 'text' as 'json'}) // the login() method of our spring security app returns a string!
  }
}

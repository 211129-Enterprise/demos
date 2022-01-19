import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { url } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class JwtClientService {

  constructor(private http: HttpClient) { } // make sure you import thie HttpClientModule to your app.module.ts

  // generateToken()
  public generateToken(request: any) {
    // hit the authenticate endpoint of our server
    return this.http.post(`${url}/authenticate`, request, {responseType: 'text' as  'json'})
  }

  // accessLogin(token) - send the request with the token to the login() method at "/"
  public accessLogin(token: string) {

    let tokenStr = `Bearer ${token}`
    const headers = new HttpHeaders().set("Authorization", tokenStr);

    return this.http.get(url, {headers, responseType: 'text' as 'json'}) // login method of our spring security app returns a string.

  }



}

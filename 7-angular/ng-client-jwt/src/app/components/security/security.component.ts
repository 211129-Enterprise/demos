import { JwtClientService } from './../../services/jwt-client.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {

  authRequest: any = {
    "username" : "person",
    "password" : "password"
  }

  response: any;

  constructor(private jwtService: JwtClientService) { }

  ngOnInit(): void {
    this.getAccessToken(this.authRequest)

  }

  // this will generate the token based on the authRequest object sent through
  public getAccessToken(authRequest: any) {

    let response = this.jwtService.generateToken(authRequest);

    response.subscribe(
      data => {
        this.accessApi(data)
      },
      error => console.log(error));

  }

  public accessApi(token: any) {
    let resp = this.jwtService.accessLogin(token);
    resp.subscribe(
      data => this.response = data,
      error => console.log(error)
    )
  }

}

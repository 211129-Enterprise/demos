import { Component, OnInit } from '@angular/core';
import { JwtClientService } from 'src/app/services/jwt-client.service';


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

    this.getAccessToken(this.authRequest);
  }


  // this will generate the token based on the authrequest object sent thru
  public getAccessToken(authRequest: any) {

    let resp =  this.jwtService.generateToken(authRequest);

    resp.subscribe(data =>
      {
        // console.log(data)
        this.accessApi(data);
      },
        error => console.log(error));
  }

  public accessApi(token: any) {

    let resp = this.jwtService.acceessLogin(token);
    resp.subscribe(data => this.response = data); // the string returned from the controller's login() method "You're logged in!"
  }

}

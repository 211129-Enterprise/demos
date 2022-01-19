import { JwtClientService } from 'src/app/services/jwt-client.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  // modify line 8 of tsconfig.json to set strict to false
  username : string;
  password : string;

  constructor(private jwtService: JwtClientService, private router: Router) { }

  doLogin() {

    // this will call a login() method from the jwtService
    // pass the username and password properties to the login() method inside the jwtService
    let resp = this.jwtService.login(this.username, this.password)

    resp.subscribe(data => {
      this.router.navigate(['/home']) // think of ways in which you would append this to the header
    },
    error => this.router.navigate(['/login']))
  }

}

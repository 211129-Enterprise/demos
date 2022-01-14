import { ClientMessage } from './../../models/client-message';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User, Address } from 'src/app/models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  title = 'Register User'
  public user =  new User(0, '', '', '', '', '', []);
  public address = new Address('', '', '', '', '');
  public clientMessage = new ClientMessage(''); // This will alert the user as to whether the registration was successful


  constructor(private userService: UserService) { }

  public registerUser(): void {

    this.user.addresses.push(this.address);

    this.userService.registerUser(this.user)
      .subscribe(
        data => this.userService.logger.log(data),
        error => this.userService.logger.error(error)
        )
  }




}

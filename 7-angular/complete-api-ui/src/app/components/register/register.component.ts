import { ClientMessage } from './../../models/client-message';
import { Component, OnInit } from '@angular/core';
import { User , Address } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  title= 'Register User';
  public user = new User(0,'', '', '', '', '', []);
  public address = new Address('','','','','');
  public clientMessage = new ClientMessage(''); // This will allow some type of alert to the user

  constructor(private userService: UserService) { }

  public registerUser(): void {

    this.user.addresses.push(this.address);

    this.userService.registerUser(this.user)
      .subscribe(
        data => this.clientMessage.message = `Successfully registered ${data.firstName}`, // data => this.userService.logger.log(data),
        error => this.clientMessage.message = `Something went wrong. Error: ${error}`   // error => this.userService.logger.error(error)
      )
  }
}

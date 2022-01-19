import { Component, OnInit } from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-remove',
  templateUrl: './remove.component.html',
  styleUrls: ['./remove.component.css']
})
export class RemoveComponent {

  title = "Remove User By Id"
  userId: number = 0; // now we need to bind the input from the template to this property of the component
  clientMessage = new ClientMessage('');


  constructor(private userService: UserService ) { }

  public removeUser() {

    // call the findUserById() method from teh userService
    this.userService.removeUserById(this.userId)
      .subscribe(
        data => this.clientMessage.message = `Successfully removed User with ID: ${this.userId}`,
        error => this.clientMessage.message = `Unable to remove User with ID: ${this.userId}!`
        );
    // subscribe to what it returns -> take the data and build a user object to render on the view

  }
}

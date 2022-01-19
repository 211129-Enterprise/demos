import { Component, OnInit } from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message';
<<<<<<< HEAD
import { User } from 'src/app/models/user';
=======
>>>>>>> main
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-remove',
  templateUrl: './remove.component.html',
  styleUrls: ['./remove.component.css']
})
export class RemoveComponent {

<<<<<<< HEAD
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
=======
  title = 'Remove User By Id'
  userId: number = 0; // now we need to bind the input from the template to this property of the component
  clientMessage = new ClientMessage('');

  // TODO: we will call maybe the find by ID method within the UserService
  constructor(private userService: UserService) { }

  public removeUser() {

    this.userService.deleteUser(this.userId)
      .subscribe(
        data => this.clientMessage.message = `Removed user with ID ${this.userId}`,
        error => this.clientMessage.message = `Unable to remove user with ID ${this.userId}`
      )

  }

>>>>>>> main
}

import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user';
import { ClientMessage } from 'src/app/models/client-message';

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent {

  title = 'Find User By Id'
  userId: number = 0; // now we need to bind the input from the template to this property of the component
  public user =  new User(0, '', '', '', '', '', []); // we need to share this user object with the html template
  clientMessage = new ClientMessage('');

  // TODO: we will call maybe the find by ID method within the UserService
  constructor(private userService: UserService) { }

  public findUser() {

    // call the findUserById() method from the userService
    this.userService.findUserById(this.userId)
      .subscribe(
        data => this.user = data,
        error => this.clientMessage.message = `Can't Find that User!`)
    // the subscribe to what it returns -> take the data and build a User object to render on the view
  }

}

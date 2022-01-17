import { UserService } from './../../services/user.service';
import { ClientMessage } from './../../models/client-message';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { LoggerService } from 'src/app/services/logger.service';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css'],
})
export class AllComponent implements OnInit {
  title = 'All Users';
  public users: User[] = [];

  public clientMessage: ClientMessage = new ClientMessage(
    'Sorry no users to display'
  ); // calling constructor to initialize constructor property

  // later we will inject a UserService which will have an HttpClient module injected into it
  constructor(private userService: UserService) {}

  ngOnInit(): void {
    // when the component is initialized, populate the users array with all the users in the DB
    this.findAllUsers(); // calls the below method.
  }

  findAllUsers() {
    // We're calling a method from the UserService that will return an Observable
    this.userService.findAllUsers().subscribe((data) => {
      this.userService.logger.log(data.length);
      this.users = data;
    });
  }
}

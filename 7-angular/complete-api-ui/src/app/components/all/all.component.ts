import { LoggerService } from './../../services/logger.service';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {

  title= "All Users"
  public users: User[] = []

  public clientMessage: ClientMessage = new ClientMessage('Sorry no users to display');

  constructor(private userService: UserService, private logger: LoggerService) { }

  ngOnInit(): void {

    // when the component is initialized, populate the users array with all the users in the DB
    this.findAllUsers(); // calls the method
  }

  findAllUsers() {
    // We are calling a method from the user service that will return an Observable
    this.userService.findAllUsers()
                    .subscribe(data => {
                      this.userService.logger.log(data.length);
                      this.users = data;  // you must subscribe to an observable to process its data
                    });
  }

}

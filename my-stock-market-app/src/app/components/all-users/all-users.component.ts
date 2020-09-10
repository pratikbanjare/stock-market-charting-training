import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {

  users : User[] = [
    {
      userId: 1,
      username : 'pratik',
      userPassword: 'banjare',
      emailId: 'pb@gm.co',
      userType: 0,
      mobileNumber : '1234567890',
      confirmed: true
    },
    {
      userId: 2,
      username : 'vicky',
      userPassword: 'kaushal',
      emailId: 'vk@gm.co',
      userType: 0,
      mobileNumber : '0987654321',
      confirmed: true
    }
  ];
  constructor( private userService : UserService ) { }

  ngOnInit(): void {
    /*
    this.userService.getAllUseres().subscribe(
      data =>{
        this.users = data;
        console.log(this.users);
        
      }
      */
    console.log(this.users);     

    
  }

}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder,  Validators } from '@angular/forms';
import  {User} from '../../models/user';
import { UserService } from '../../services/user.service'
@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup;
  user : User;
  
  constructor(private formBuilder : FormBuilder, private service: UserService) {
  }

  ngOnInit(): void {
    this.initfForm();
  }
  initfForm() : void {

    this.loginForm = this.formBuilder.group( {
      userPassword : ['', Validators.required],
      username : ['', Validators.required]
    });

    this.service.getHello ().subscribe (data => {
      console.log(data);
    })
  }

  isValidInput(fieldName) : boolean {
    return this.loginForm.controls[fieldName].invalid && 
          (this.loginForm.controls[fieldName].dirty || this.loginForm.controls[fieldName].touched )
    
  }

  login() : void{
    console.log(this.loginForm.value);
    this.service.getUserByName( 'pratik' ).subscribe (data => {
      console.log(data);  
    });
    

  }

}

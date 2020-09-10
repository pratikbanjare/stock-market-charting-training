import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder,  Validators } from '@angular/forms';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup;
 
  constructor(private formBuilder : FormBuilder) {


  }

  ngOnInit(): void {
    this.initfForm();
  }
  initfForm() : void {

    this.loginForm = this.formBuilder.group( {
      userPassword : ['', Validators.required],
      username : ['', Validators.required]
    });
  }

  isValidInput(fieldName) : boolean {
    return this.loginForm.controls[fieldName].invalid && 
          (this.loginForm.controls[fieldName].dirty || this.loginForm.controls[fieldName].touched )
    
  }

  login() : void{
    console.log(this.loginForm.value);
  }

}

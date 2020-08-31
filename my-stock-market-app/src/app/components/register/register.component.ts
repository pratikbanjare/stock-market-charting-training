import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  constructor( private formBuilder : FormBuilder) { }

  ngOnInit(): void {
    this.initForm();
  }
  initForm() : void {
    this.registerForm = this.formBuilder.group( {
      username : ['', Validators.required],
      userPassword : ['', Validators.required],
      emailId : ['', [Validators.required, Validators.pattern(
        '^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$'
      )]],
      mobileNumber : ['',Validators.pattern("[0-9]{10}$")]
    });
  }

  isValidInput (fieldName): boolean {
    return this.registerForm.controls[fieldName].invalid &&
    ( this.registerForm.controls[fieldName].dirty || this.registerForm.controls[fieldName].touched )
  }

  register() : void{
    console.log(this.registerForm.value);
    
  }
}

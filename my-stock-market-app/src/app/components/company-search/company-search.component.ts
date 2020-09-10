import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-company-search',
  templateUrl: './company-search.component.html',
  styleUrls: ['./company-search.component.css']
})
export class CompanySearchComponent implements OnInit {

  companyName :string;
  date1 : Date;
  date2: Date;
  clicked : boolean;
  arr: number[] = [1,2,3,4];
  constructor() {  }

  ngOnInit(): void {
    this.initForm();
    
  }

  initForm() : void{
    
  }
  companyStock() : void {
    console.log(this.companyName);
    console.log(this.date1);
    console.log(this.date2);
    this.clicked = true;   
    
  }
}

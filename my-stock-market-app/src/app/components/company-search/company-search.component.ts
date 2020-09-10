import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-company-search',
  templateUrl: './company-search.component.html',
  styleUrls: ['./company-search.component.css']
})
export class CompanySearchComponent implements OnInit {

  companySearch : FormGroup;
  constructor(private formBuilder : FormBuilder) {  }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() : void{
    this.companySearch = this.formBuilder.group({
      companyName : '',
      dateFrom : '',
      dataTo : ''
    });

  }
  companyStock() : void {
    console.log(this.companySearch.value);
  }
}

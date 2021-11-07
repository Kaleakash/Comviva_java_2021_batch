import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(public empSer:EmployeeService) { }    // DI for EmployeeService 

  ngOnInit(): void {
  }

  loadJson() {
    this.empSer.loadJsonData();
  }
}

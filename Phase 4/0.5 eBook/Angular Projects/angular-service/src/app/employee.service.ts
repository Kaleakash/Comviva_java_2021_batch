import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'      // this property is like a provider attribute in app.module.ts 
})
export class EmployeeService {

  constructor(public http: HttpClient) { }  // DI for HttpClient API


  loadJsonData() {
    this.http.get("./assets/employees.json").
    subscribe(result=>console.log(result),error=>console.log(error),()=>console.log("completed"));
  }
}

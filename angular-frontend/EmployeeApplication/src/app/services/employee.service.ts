import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient: HttpClient) { }

  employeeList():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`http://localhost:8083/ema/employees`);
  }

  getEmployeeById(id:number):Observable<Employee>{
    return this.httpClient.get<Employee>(`http://localhost:8083/ema/employees/${id}`);
  }

  addEmployee(firstName:string,lastName:string,email:string,mobileNumber:string) {
    return this.httpClient.post<Employee>(`http://localhost:8083/ema/employees`,{firstName,lastName,email,mobileNumber});
  }

  deleteEmployee(id:number) {
    return this.httpClient.delete<Employee>(`http://localhost:8083/ema/employees/${id}`);
  }

  updateEmployee(id:number, employee: Employee) {
    return this.httpClient.put<Employee>(`http://localhost:8083/ema/employees/${id}`,employee);
  }


}
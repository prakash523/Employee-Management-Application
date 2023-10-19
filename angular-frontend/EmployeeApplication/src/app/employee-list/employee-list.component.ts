import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../models/employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{

  employees: Employee[];

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  getEmployees(){
    this.employeeService.employeeList().subscribe(data=>{
      this.employees=data;
    })
  }

  details(id:number) {
    this.router.navigate(['employee-details',id]);
  }

  deleteEmployee(id:number) {
    this.employeeService.deleteEmployee(id).subscribe(data=>{
      this.getEmployees();
      console.log(data);
    })
  }

  updateEmployee(id:number) {
    this.router.navigate(['update-employee',id]);
  }

}

import { Component, OnInit } from '@angular/core';
import { Employee } from '../models/employee';
import { EmployeeService } from '../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit{

  employee: Employee;
  firstName:string;
  lastName:string;
  email:string;
  mobileNumber:string;

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    // this.submit();
  }

  submit() {
    // this.employee={"id":2,"firstName":"fn","lastName":"ls","mobileNumber":"933334","email":"emailid"};
    this.employeeService.addEmployee(this.firstName,this.lastName,this.email,this.mobileNumber).subscribe(data=>{
      console.log(data);
      this.router.navigate(['employee-list']);
    })
  }



}

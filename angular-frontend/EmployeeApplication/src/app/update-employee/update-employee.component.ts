import { Component, OnInit } from '@angular/core';
import { Employee } from '../models/employee';
import { EmployeeService } from '../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit{

  id: number;
  employee: Employee;

  constructor(private employeeService: EmployeeService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id']
    this.employeeService.getEmployeeById(this.id).subscribe(data=>{
      this.employee = data;
    });
  }

  updateEmployee(){
    this.employeeService.updateEmployee(this.id,this.employee).subscribe(data=>{
      console.log(data);
      this.router.navigate(['employee-list']);
    })
  }

}

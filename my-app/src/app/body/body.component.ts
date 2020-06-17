import { Component, OnInit } from '@angular/core';
import { DepartmentService } from './department/services/department.service';
import { Department } from './types/department';
import { Router } from '@angular/router';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {

  browse = new Department(0, '');
  constructor(private departmentService: DepartmentService, private route: Router) { }

  ngOnInit(): void {
  }

  onShopNowClick() {
    this.departmentService.selectedDepartmentUpdated.next(this.browse);
    this.route.navigateByUrl('/department');
  }
}

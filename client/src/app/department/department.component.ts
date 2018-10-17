import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable } from  "rxjs" ;



export interface Food {
  value: number;
  viewValue: string;
}

export interface Department {
  department_id: number;
  department_name: string;
}





@Injectable()
@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})




export class DepartmentComponent implements OnInit {


  foods: Food[] = [];


  departments: Department[]= [] ;




  private person_id: number;
  private deployid: number;



  displayedColumns: string[] = ['codenum', 'name', 'depart', 'phone'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor( private httpClient: HttpClient){}

  changedeploy(){

    this.ChangeDeploy(this.person_id, this.deployid).subscribe(data => {
      console.log( "Update Success" , data) ;
      alert('แก้ไขเรียบร้อย');

    },error =>{
      console.log("Fail Success", error);
      alert('ไม่สามารถแก้ไขได้ server ผิดพลาดหรือไม่มีข้อมูล');

    })



  }
  ChangeDeploy(person_id: number , deploy_id: number){

    return this.httpClient.post('//localhost:8080/Positions',{

      "deploy": deploy_id,
      "person": person_id

    });

  }




  ngOnInit() {


    this.httpClient.get("http://localhost:8080/Departments").subscribe(
      body => {
        console.log("GET Request is successful ", body);
        for (let index = 0; index < body["length"]; index++) {
          this.departments.push({
            department_id: body[index].deploy_id,
            department_name: body[index].deploy_name
          })


        }

      },
      error => {
        console.log("Error", error);
      }

    );






    let acc = document.getElementsByClassName('accordion');
    let i;

    for (i = 0; i < acc.length; i++) {
      acc[i].addEventListener('click', function() {
        /* Toggle between adding and removing the "active" class,
        to highlight the button that controls the panel */
        this.classList.toggle('active');

        /* Toggle between hiding and showing the active panel */
        let panel = this.nextElementSibling;
        if (panel.style.display === 'block') {
          panel.style.display = 'none';
        } else {
          panel.style.display = 'block';
        }
      });
    }
  }




}
export interface PeriodicElement {
  codenum: string;
  name: string;
  depart: string;
  phone: string;
}


const ELEMENT_DATA: PeriodicElement[] = [
  {phone: '0888888888', codenum: 'b5900', name: 'Mo', depart: 'cpe'},
  {phone: '0899999999', codenum: 'b5901', name: 'MAY', depart: 'cpe'},
  {phone: '0877777777', codenum: 'b5902', name: 'MAI', depart: 'cpe'},
  {phone: '0866666666', codenum: 'b5903', name: 'MING', depart : 'cpe'},
  {phone: '0855555555', codenum: 'b5904', name: 'MoNG', depart : 'cpe'},

];




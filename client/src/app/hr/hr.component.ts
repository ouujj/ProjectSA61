import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {HttpClient} from '@angular/common/http';

export interface PeriodicElement {

  personid: string;
  name: string;
  email: string;
  phone: string;
}

@Component({
  selector: 'app-hr',
  templateUrl: './hr.component.html',
  styleUrls: ['./hr.component.css']
})
export class HRComponent implements OnInit {

  displayedColumns: string[] = ['personid','name', 'phone', 'email'];
  dataSource = new MatTableDataSource();

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor(private http: HttpClient) { }


  ngOnInit() {
    const ELEMENT_DATA: PeriodicElement[] = [];

    this.http.get("http://localhost:8080/persons").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          ELEMENT_DATA.push({

            personid : data[index].personid,
            name     : data[index].name,
            email    : data[index].email,
            phone    : data[index].phone

          })


        }
        //console.log(ELEMENT_DATA);
        this.dataSource = new MatTableDataSource(ELEMENT_DATA);
      },
      error => {
        console.log("Error", error);
      }

    );


  }

}






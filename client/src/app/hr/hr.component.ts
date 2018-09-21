import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-hr',
  templateUrl: './hr.component.html',
  styleUrls: ['./hr.component.css']
})
export class HRComponent implements OnInit {

  displayedColumns: string[] = ['codenum', 'name', 'depart', 'phone'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }





  constructor() { }

  ngOnInit() {




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


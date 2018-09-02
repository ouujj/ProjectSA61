import {Component,OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material';


// @ts-ignore
// @ts-ignore
// @ts-ignore
@Component({
  selector: 'app-record',
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.css']
})




export class RecordComponent implements OnInit {

  displayedColumns: string[] = ['intime', 'codenum', 'name', 'depart'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  constructor() {

  }
  ngOnInit() {

  }

}

export interface PeriodicElement {
  name: string;
  intime: string;
  codenum: string;
  depart: string;
}


const ELEMENT_DATA: PeriodicElement[] = [
  {intime: '5/6/2018 07:45', codenum: 'b5900', name: 'Mo', depart: 'cpe'},
  {intime: '5/6/2018 07:46', codenum: 'b5901', name: 'MAY', depart: 'cpe'},
  {intime: '5/6/2018 07:47', codenum: 'b5902', name: 'MAI', depart: 'cpe'},
  {intime: '5/6/2018 07:48', codenum: 'b5903', name: 'MING',depart : 'cpe'},
  {intime: '5/6/2018 07:49', codenum: 'b5904', name: 'MoNG',depart : 'cpe'},
  {intime: '6/6/2018 07:49', codenum: 'b5900', name: 'Mo', depart: 'cpe'},
  {intime: '6/6/2018 07:48', codenum: 'b5901', name: 'MAY', depart: 'cpe'},
  {intime: '6/6/2018 07:47', codenum: 'b5902', name: 'MAI', depart: 'cpe'},
  {intime: '6/6/2018 07:46', codenum: 'b5903', name: 'MING',depart : 'cpe'},
  {intime: '6/6/2018 07:45', codenum: 'b5904', name: 'MoNG', depart: 'cpe'},
];

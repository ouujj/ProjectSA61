import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable } from  "rxjs" ;


@Injectable()
@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.css']
})
export class ManageComponent implements OnInit {


    private person_id: number;
    private person_name: string;
    private person_address: string;
    private person_birthday: string;
    private person_phone: string;
    private person_email: string;
    private person_ssid: string;






  constructor(
    private httpClient: HttpClient
  ){}

  Addp() {
    this.Addperson(this.person_name,this.person_address,this.person_birthday,this.person_phone,this.person_email,this.person_ssid).subscribe(data => {
      console.log( "POST Success" , data) ;
      alert('เพิ่มเรียบร้อย');

  },error =>{
      console.log("Fail Success", error);
      alert('ไม่สามารถแก้ไขได้ server ผิดพลาดหรือไม่มีข้อมูล');
    })
  }

  Delp() {

    this.httpClient.delete('http://localhost:8080/persons/delete/' + this.person_id)
      .subscribe(
        data => {
          alert('ลบเรียบร้อย');
          console.log('delete Request is successful', data);


        },
        error => {
          console.log('Rrror', error);
          alert('ไม่สามารถลบได้ server ผิดพลาดหรือไม่มีข้อมูล');
        }
      );

  }

  Update(){

    this.UpdateInfo(this.person_id,this.person_name,this.person_address,this.person_birthday,this.person_phone,this.person_email,this.person_ssid).subscribe(data => {
      console.log( "Update Success" , data) ;
      alert('แก้ไขเรียบร้อย');

    },error =>{
      console.log("Fail Success", error);
      alert('ไม่สามารถแก้ไขได้ server ผิดพลาดหรือไม่มีข้อมูล');

    })




  }





  ngOnInit() {


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

  public Addperson(  person_name: string, person_address: string,  person_birthday: string,
                     person_phone: string, person_email: string, person_ssid: string ) : Observable <any>{
    return  this.httpClient.post('//localhost:8080/persons',{

      "name":person_name,
     "phone":person_phone,
     "addrees":person_address,
     "email":person_email,
     "ssid":person_ssid,
     "birthday":person_birthday

    });
  }
  public UpdateInfo( person_id: number, person_name: string, person_address: string,  person_birthday: string,
                      person_phone: string, person_email: string, person_ssid: string ) : Observable <any>{
    return  this.httpClient.put('//localhost:8080/persons/update',{

      "personid":person_id,
      "name":person_name,
      "phone":person_phone,
      "addrees":person_address,
      "email":person_email,
      "ssid":person_ssid,
      "birthday":person_birthday

    });
  }




  }


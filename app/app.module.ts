import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import {CdkTableModule} from '@angular/cdk/table';
import {CdkTreeModule} from '@angular/cdk/tree';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { MatGridListModule, MatTableModule, MatTabsModule, MatSelectModule, MatIconModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HRComponent } from './hr/hr.component';
import { DepartmentComponent } from './department/department.component';
import { ManageComponent } from './manage/manage.component';
import { RecordComponent } from './record/record.component';




const appRoutes: Routes = [
  {path: '', component : HRComponent},
  {path: 'manage', component : ManageComponent},
  {path: 'record', component : RecordComponent},
  {path: 'department', component : DepartmentComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HRComponent,
    DepartmentComponent,
    ManageComponent,
    RecordComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatGridListModule,
    MatTabsModule,
    MatSelectModule,
    MatTableModule,
    MatIconModule,
    CdkTableModule,
    CdkTreeModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

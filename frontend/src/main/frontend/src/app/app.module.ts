import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';

import { HttpClientModule } from '@angular/common/http';
import { WelcomeComponent } from 'app/home/welcome.component';
import { DrugModule } from './drugs/drug.module';
import { BillModule } from './bills/bill.module';
import { ManufacturerModule } from './manufacturer/manufacturer.module';
import { HttpModule } from '@angular/http';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
  
  ],
  imports: [
    HttpModule,
    BrowserModule,
    HttpClientModule, 
    RouterModule.forRoot([ 
      { path: 'welcome', component: WelcomeComponent },
      { path: '', redirectTo: 'welcome', pathMatch: 'full'},
      { path: '**', redirectTo: 'welcome', pathMatch: 'full'}
  ]), 
   DrugModule,
   BillModule, 
   ManufacturerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


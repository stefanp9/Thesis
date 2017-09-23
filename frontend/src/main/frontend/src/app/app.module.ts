import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms'
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';

import { DrugListComponent } from "./drugs/drug-list.commponent";
import { HttpClientModule } from '@angular/common/http';
import { DrugDetailComponent } from './drugs/drug-detail.component';
import { WelcomeComponent } from 'app/home/welcome.component';
import { ManufacturerListComponent } from './manufacturer/manufacturer-list.component';
import { ManufacturerDetailComponent } from './manufacturer/manufacturer-detail.component';
import { BillListComponent } from './bills/bill-list.component';
import { BillDetatilComponent } from './bills/bill-detatil.component';


@NgModule({
  declarations: [
    AppComponent,
    DrugListComponent,
    DrugDetailComponent,
    WelcomeComponent,
    ManufacturerListComponent,
    ManufacturerDetailComponent,
    BillListComponent,
    BillDetatilComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule, 
    RouterModule.forRoot([
      { path: 'drugs', component: DrugListComponent },
      { path: 'drugs/:id', component: DrugDetailComponent },
      {path: 'manufacturers', component: ManufacturerListComponent },
      {path: 'manufacturers/:id', component: ManufacturerDetailComponent },
      {path: 'bills', component: BillListComponent},
      {path: 'bills/:id', component: BillDetatilComponent},
      { path: 'welcome', component: WelcomeComponent },
      { path: '', redirectTo: 'welcome', pathMatch: 'full'},
      { path: '**', redirectTo: 'welcome', pathMatch: 'full'}
  ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


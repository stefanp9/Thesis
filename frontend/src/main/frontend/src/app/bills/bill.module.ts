import { NgModule } from '@angular/core';
import { BillDetatilComponent } from './bill-detatil.component';
import { BillListComponent } from './bill-list.component';
import { RouterModule } from '@angular/router';
import { BillService } from './bill.service';
import { SharedModule } from './../shared/shared.module';

@NgModule({
  imports: [
    RouterModule.forChild([
      {path: 'bills', component: BillListComponent},
      {path: 'bills/:id', component: BillDetatilComponent}
    ]),
    SharedModule
  ],
  declarations: [
    BillListComponent,
    BillDetatilComponent
  ],
  providers: [BillService]
})
export class BillModule { }

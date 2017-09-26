import { NgModule } from '@angular/core';
import { DrugDetailComponent } from './drug-detail.component';
import { DrugListComponent } from './drug-list.commponent';
import { RouterModule } from '@angular/router';
import { DrugService } from './drug.service';
import { SharedModule } from './../shared/shared.module';
import { DrugEditComponent } from './drug-edit.component';

@NgModule({
  imports: [
    RouterModule.forChild([
      { path: 'drugs', component: DrugListComponent },
      { path: 'drugs/:id', component: DrugDetailComponent },
      { path: 'drugEdit/:id', component : DrugEditComponent}
    ]),
    SharedModule,
    
  ],
  declarations: [
    DrugListComponent,
    DrugDetailComponent,
    DrugEditComponent
  ],
  providers: [DrugService],
})
export class DrugModule { }
